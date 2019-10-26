package com.vamanos.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vamanos.entity.AppInstanceData;
import com.vamanos.entity.GlobalApps;
import com.vamanos.model.ContextMenuList;
import com.vamanos.model.DesktopItemList;
import com.vamanos.model.DesktopItemView;
import com.vamanos.model.IconsList;
import com.vamanos.model.StartMenuList;
import com.vamanos.service.AppService;

@Component
public class DesktopUpdateUtil {
	
	@Autowired
	AppService appService;
	
	StartMenuList startMenuList = null;
	ContextMenuList contextMenuList = null;
	DesktopItemList desktopItemList = null;
	DesktopItemView desktopItemView = null;
	IconsList iconsList = null;
	
	public ObjectNode updateDesktop(String state) {
		desktopItemView = new DesktopItemView();


		if("init".equals(JsonUtil.getJsonValue(state, "state"))) {
			ObjectNode node = JsonUtil.getEmptyJsonObject();
			startMenuList = new StartMenuList();
			contextMenuList = new ContextMenuList();
			iconsList = new IconsList();
		
			
			node.set("startMenuOption", startMenuList.getStartMenuList());
			node.set("contextMenuOption", contextMenuList.getcontextMenuList());
			node.set("iconsList", iconsList.getIconList());
			node.put("loggedInUserName", SecurityContextHolder.getContext().getAuthentication().getName());
			return node;
		}
		
		  else if("update".equals(JsonUtil.getJsonValue(state, "state"))){
		  if("on-double-click".equals(JsonUtil.getJsonValue(state, "action"))) 
		  	{
			  return desktopItemView.getDesktopItemView(JsonUtil.getJsonValue(state, "desktopItem"));  
		  	}
		  else if("on-desktop-icons-load".equals(JsonUtil.getJsonValue(state, "action"))) 
		  	{
			  iconsList = new IconsList();
			  return iconsList.getIconList();
			 
			}
		  else if("on-desktop-item-load".equals(JsonUtil.getJsonValue(state, "action"))) 
		  	{
			  desktopItemList = new DesktopItemList();
			  
			 
			  
			  return null;
			 
			}
		  
		  }
		 

		return JsonUtil.getEmptyJsonObject();
	}
	
	public ArrayNode getDesktopApps() {
		 List<AppInstanceData> globalApps = appService.getGlobalApps();
		 return JsonUtil.getAppListAsJsonArray(globalApps);
	}
	
	public String getAppPayload(int appId) {
		 return appService.getAppPayload(appId);
	}
	
	public String updatePayload(int appId,String payload) {
		 return appService.updateAppPayload(appId, payload);
	}
}
