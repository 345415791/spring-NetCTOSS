package com.wp.netctoss.service;
//应用异常
//自己开发ApplicationException异常
public class ApplicationException extends RuntimeException {

	public ApplicationException() {
	}
	public ApplicationException(String message) {
		super(message);
	}

}
