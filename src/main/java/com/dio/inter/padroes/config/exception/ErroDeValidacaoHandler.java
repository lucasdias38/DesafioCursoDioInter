package com.dio.inter.padroes.config.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroDeValidacaoHandler {
	@ExceptionHandler(InterException.class)
		public ResponseEntity<StandardError> interException(InterException e, HttpServletRequest request) {
			String error = "INTER-Exception error";
	        HttpStatus status = HttpStatus.BAD_REQUEST;
	        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
	        return ResponseEntity.status(status).body(err);
	    }
}
