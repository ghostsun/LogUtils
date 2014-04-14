package com.sunan.logutils;

import java.util.HashMap;
import java.util.Map;

public class LogStatistics {
	
	private static final Map<String, long[]> fileTypeMap = new HashMap<String, long[]>();
	
	private static final Map<String, Map<String, long[]>> urlMap = new HashMap<String, Map<String, long[]>>();
	
	public static void addFileType(String fileType){
		long[] value = fileTypeMap.get(fileType);
		if(value == null){
			value = new long[]{0};
		}
		value[0] += 1;
		fileTypeMap.put(fileType, value);
	}
	
	public static void addUrl(String url, String statusCode){
		Map<String, long[]> statusCodeMap = urlMap.get(url);
		if(statusCodeMap == null){
			statusCodeMap = new HashMap<String, long[]>();
		}
		
		long[] value = statusCodeMap.get(statusCode);
		if(value == null){
			value = new long[]{0};
		}
		
		value[0] += 1;
		statusCodeMap.put(statusCode, value);
		urlMap.put(url, statusCodeMap);
	}

	public static Map<String, long[]> getFiletypemap() {
		return fileTypeMap;
	}

	public static Map<String, Map<String, long[]>> getUrlmap() {
		return urlMap;
	}
	

}
