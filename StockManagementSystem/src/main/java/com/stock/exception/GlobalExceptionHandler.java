package com.stock.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class) 
	public ResponseEntity<MyErrorDetails> myMANVExeception( MethodArgumentNotValidException me){
		
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage("Validation Error....!");
		error.setDescription(me.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class) 
	public ResponseEntity<MyErrorDetails> myPNFExeception( ProductNotFoundException pe , WebRequest wr){
		
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(pe.getMessage());
		error.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(StockNotFoundException.class) 
	public ResponseEntity<MyErrorDetails> mySNFExeception( StockNotFoundException snfe , WebRequest wr){
		
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(snfe.getMessage());
		error.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StoreLocationNotFound.class) 
	public ResponseEntity<MyErrorDetails> mySLNFExeception( StoreLocationNotFound slnf , WebRequest wr){
		
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(slnf.getMessage());
		error.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	
}
