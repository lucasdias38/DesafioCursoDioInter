package com.dio.inter.padroes.config.exception;

@SuppressWarnings("serial")
public class InterException extends RuntimeException {
	
	public InterException(Object id) {
		super("Resource not found. Id: " + id);
	}
	
	public InterException(String msg) {
		super(msg);
	}
	
}
