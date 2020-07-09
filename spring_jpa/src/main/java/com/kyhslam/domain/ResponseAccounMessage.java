package com.kyhslam.domain;

import org.springframework.http.HttpStatus;

public class ResponseAccounMessage {
	
	private int code;
	private boolean status;
	private String message;
	
	private Company company;
	
	public ResponseAccounMessage(HttpStatus httpstatus) {
		
		this.code = httpstatus.value();
		this.status = (httpstatus.isError()) ? false:true;
		this.message = httpstatus.getReasonPhrase();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	

}
