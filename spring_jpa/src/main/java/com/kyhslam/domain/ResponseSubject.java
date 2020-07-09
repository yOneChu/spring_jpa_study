package com.kyhslam.domain;


import org.springframework.http.HttpStatus;

public class ResponseSubject {

	private int code;
	private boolean status;
	private String message;
	
	private RelatedSubject subject;
	
	
	public ResponseSubject(HttpStatus httpstatus) {
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

	public RelatedSubject getSubject() {
		return subject;
	}

	public void setSubject(RelatedSubject subject) {
		this.subject = subject;
	}

}
