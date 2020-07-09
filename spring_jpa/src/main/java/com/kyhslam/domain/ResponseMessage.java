package com.kyhslam.domain;

import org.springframework.http.HttpStatus;

public class ResponseMessage {
	
	
	private int code;
	private boolean status;
	private String message;
	
	private SampleVO sample;
	
	
	public ResponseMessage(HttpStatus httpstatus) {
		this.code = httpstatus.value();
		this.status = (httpstatus.isError()) ? false:true;
		this.message = httpstatus.getReasonPhrase();
	}
	
	
	
	
	
	public SampleVO getSample() {
		return sample;
	}
	public void setSample(SampleVO sample) {
		this.sample = sample;
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



	
}
