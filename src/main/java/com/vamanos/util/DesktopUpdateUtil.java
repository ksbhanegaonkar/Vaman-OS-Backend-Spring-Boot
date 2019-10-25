package com.vamanos.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.node.ObjectNode;
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
	
	public String updateDesktop(String state) {
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
			return node.toString();
		}
		
		  else if("update".equals(JsonUtil.getJsonValue(state, "state"))){
		  if("on-double-click".equals(JsonUtil.getJsonValue(state, "action"))) 
		  	{
			  return desktopItemView.getDesktopItemView(JsonUtil.getJsonValue(state, "desktopItem"));  
		  	}
		  else if("on-desktop-icons-load".equals(JsonUtil.getJsonValue(state, "action"))) 
		  	{
			  iconsList = new IconsList();
			  return iconsList.getIconList().toString();
			 
			}
		  else if("on-desktop-item-load".equals(JsonUtil.getJsonValue(state, "action"))) 
		  	{
			  desktopItemList = new DesktopItemList();
			  return desktopItemList.getDesktopItemList(appService).toString();
			 
			}
		  
		  }
		 

		return "{'empty':'empty'}";
	}
}
