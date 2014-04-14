package com.sunan.logutils.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain<T> {
	
	List<Filter<T>> filters = new ArrayList<Filter<T>>();
	
	public FilterChain<T> add(Filter<T> f){
		filters.add(f);
		return this;
	}
	
	public T doFilter(T t) throws Exception{
		for(Filter<T> f: filters){
			f.doFilter(t);
		}
		
		return t;
		
	}

}
