package com.sunan.logutils.bean;

/**
 * SourceLine
 * @author sunan
 * @Time 2014-4-14 下午5:17:29
 */
public class SourceLine {
	
	private long index = -1;
	
	private String item;
	
	public SourceLine(long index, String item){
		this.index = index;
		this.item = item;
	}

	public long getIndex() {
		return index;
	}

	public void setIndex(long index) {
		this.index = index;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
	

}
