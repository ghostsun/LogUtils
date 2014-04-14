package com.sunan.logutils;

import com.sunan.logutils.bean.LogLine;

public interface LogProcess<T> {
	
	public LogLine process(T t) throws Exception;

}
