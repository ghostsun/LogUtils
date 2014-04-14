package com.sunan.logutils.filter;

import com.sunan.logutils.LogStatistics;
import com.sunan.logutils.bean.LogLine;

public class FileTypeLogFilter implements Filter<LogLine> {

	@Override
	public void doFilter(LogLine line) throws Exception {
		LogStatistics.addFileType(line.getFileType());
		
	}


}
