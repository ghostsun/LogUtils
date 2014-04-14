package com.sunan.logutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import com.sunan.logutils.bean.LogLine;
import com.sunan.logutils.bean.SourceLine;

public class IISLogProcess implements LogProcess<SourceLine> {
	
//	private static final SimpleDateFormat sdf  =   new  SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ); 

	@Override
	public LogLine process(SourceLine line) throws LogException, ParseException {
		LogLine result = new LogLine();
		SimpleDateFormat sdf  =   new  SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ); 
		
		if(line == null){
			throw new LogException("this line is null");
		}
		if(StringUtils.isBlank(line.getItem())){
			throw new LogException("this line's item is null");
		}
		
		if(line.getIndex() < 0){
			throw new LogException("this line's index is error");
		}
		
		long index = line.getIndex();
		String[] lineArray = line.getItem().split(" ");
		
		if (lineArray.length < 14) {
			throw new LogException("the " + index + "st line is error, length = " + lineArray.length);
		}
		
		if(index != 4){
			result.setUrl(lineArray[4].toLowerCase());
			result.setStatusCode(lineArray[10]);
			result.setTime(Long.parseLong(lineArray[13]));
			result.setFileType(getFileType(result.getUrl()));
			result.setDate(sdf.parse(lineArray[1] + " " + lineArray[2]));
		}
		
		
		return result;
	}
	
	private String getFileType(String url){
		String fileType = null;
		if(StringUtils.isBlank(url)){
			return "";
		}
		int dotIndex = url.lastIndexOf(".");
		
		if (dotIndex == -1) {
			fileType = "unknow";
		} else {
			fileType = url.substring(dotIndex + 1);
		}
		
		if(StringUtils.isBlank(fileType)){
			fileType = "unknow";
		}
		
		return fileType;
	}

}
