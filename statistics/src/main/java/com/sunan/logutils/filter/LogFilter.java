package com.sunan.logutils.filter;

import com.sunan.logutils.LogException;
import com.sunan.logutils.bean.LogLine;

public abstract class LogFilter implements Filter<LogLine> {
	
	public void doFilter(LogLine line)throws LogException{
		realDoFilter(line);
	}	
	
	public abstract void realDoFilter(LogLine line)throws LogException;

}
