package com.sunan.logutils.bean;

import java.util.Date;

public class LogLine {

	private String url;
	
	private String fileType;
	
	private Date date;
	
	private long time;
	
	private String statusCode;
	
	private String ip;
	
	private String port;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statuCode) {
		this.statusCode = statuCode;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
	
	

}
