package com.sunan.logutils.filter;

import org.apache.commons.lang.StringUtils;

import com.sunan.logutils.LogException;
import com.sunan.logutils.bean.LogLine;

public class LineCheckLogFilter implements Filter<LogLine> {

	@Override
	public void doFilter(LogLine line) throws Exception {
		if(line == null){
			throw new LogException("line is null");
		}
		if(StringUtils.isBlank(line.getFileType())){
			throw new LogException("fileType is null");
		}
		if(StringUtils.isBlank(line.getUrl())){
			throw new LogException("url is null");
		}
		if(StringUtils.isBlank(line.getStatusCode())){
			throw new LogException("statusCode is null");
		}
		if(line.getDate() == null){
			throw new LogException("date is null");
		}
		
	}

}
