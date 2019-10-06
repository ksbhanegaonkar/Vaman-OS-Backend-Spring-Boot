package com.vamanos.util;

import java.util.HashMap;
import java.util.Map;

public class DesktopItemViewUtil {

	public Map<String, Object> getDesktopItemViewInfo(String item) {
		Map<String,Object> itemData = new HashMap<>();
		Map<String,Object> payload = new HashMap<>();
		if("MyFolder21".equals(item)) {
			payload.put("file1", "file");
			payload.put("file2", "file");
			payload.put("file3", "file");
			payload.put("MyFolder22", "folder");
			payload.put("folder2", "folder");
			payload.put("folder3", "folder");
			
			itemData.put("name", item);
			itemData.put("type", "folder");
			itemData.put("payload",payload);
		}
		
		else if("MyFolder22".equals(item)) {
			payload.put("file1", "file");
			payload.put("file2", "file");
			payload.put("file3", "file");
			
			itemData.put("name", item);
			itemData.put("type", "folder");
			itemData.put("payload",payload);
		}
		
		Map<String,Object> map = new HashMap<>();
		map.put("desktop-item-data", itemData);
		return map;
	}

}
