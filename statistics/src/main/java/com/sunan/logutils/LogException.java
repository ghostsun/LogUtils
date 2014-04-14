package com.sunan.logutils;

public class LogException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4166736363807610694L;
	
	public LogException(String message){
		super(message);
	}
	
	public LogException(){
		super();
	}

}
