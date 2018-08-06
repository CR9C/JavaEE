package com._520it._01_upload;

//业务逻辑异常
public class LogicException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public LogicException(String message, Throwable cause) {
		super(message, cause);
	}

	public LogicException(String message) {
		super(message);
	}

	
}
