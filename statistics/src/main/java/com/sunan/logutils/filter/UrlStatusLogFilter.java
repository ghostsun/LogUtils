package com.sunan.logutils.filter;

import com.sunan.logutils.LogStatistics;
import com.sunan.logutils.bean.LogLine;

public class UrlStatusLogFilter implements Filter<LogLine> {

	@Override
	public void doFilter(LogLine line) throws Exception {
		LogStatistics.addUrl(line.getUrl(), line.getStatusCode());
	}

}
