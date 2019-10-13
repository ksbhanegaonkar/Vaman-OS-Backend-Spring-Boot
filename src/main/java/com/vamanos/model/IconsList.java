package com.vamanos.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.vamanos.util.Image2Base64StringConverter;
import com.vamanos.util.JsonUtil;

public class IconsList {
	private static final String FOLDER_ICON = "src/main/resources/static/icons/folder.png";
	private static final String FILE_ICON = "src/main/resources/static/icons/file.png";
	public ObjectNode getIconList(){
		Map<String,String> iconMap = new HashMap<>();
		iconMap.put("folder", Image2Base64StringConverter.convert(FOLDER_ICON));
		iconMap.put("file", Image2Base64StringConverter.convert(FILE_ICON));
		return JsonUtil.getJsonObjectFromMap(iconMap);
	}
}
