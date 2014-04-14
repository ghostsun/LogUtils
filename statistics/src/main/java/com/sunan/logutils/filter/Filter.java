package com.sunan.logutils.filter;

public interface Filter<T> {
	
	public void doFilter(T t) throws Exception;

}
