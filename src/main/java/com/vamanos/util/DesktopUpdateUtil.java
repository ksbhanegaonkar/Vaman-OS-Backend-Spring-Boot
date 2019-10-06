package com.vamanos.util;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vamanos.model.ContextMenuList;
import com.vamanos.model.DesktopItemList;
import com.vamanos.model.DesktopItemView;
import com.vamanos.model.StartMenuList;

public class DesktopUpdateUtil {
	StartMenuList startMenuList = null;
	ContextMenuList contextMenuList = null;
	DesktopItemList desktopItemList = null;
	DesktopItemView desktopItemView = null;
	
	public String updateDesktop(String state) {
		desktopItemView = new DesktopItemView();


		if("init".equals(JsonUtil.getJsonValue(state, "state"))) {
			ObjectNode node = JsonUtil.getEmptyJsonObject();
			startMenuList = new StartMenuList();
			contextMenuList = new ContextMenuList();
			desktopItemList = new DesktopItemList();
			node.set("startMenuOption", startMenuList.getStartMenuList());
			node.set("contextMenuOption", contextMenuList.getcontextMenuList());
			node.set("desktopItems", desktopItemList.getDesktopItemList());
			return node.toString();
		}
		/*
		 * else if("update".equals(obj.get("state").getAsString())){
		 * if("on-double-click".equals(obj.get("action").getAsString())) { return
		 * desktopItemView.getDesktopItemView(obj.get("desktopItem").getAsString()); }
		 * 
		 * }
		 */

		return "{'empty':'empty'}";
	}
}
