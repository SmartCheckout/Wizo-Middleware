package com.smartshopper.models.io;

public class ErrorInfo {

	private String errorString;
	private String url;
	
	public ErrorInfo(String errorString, String url) {
		super();
		this.errorString = errorString;
		this.url = url;
	}
	
	public String getErrorString() {
		return errorString;
	}
	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
