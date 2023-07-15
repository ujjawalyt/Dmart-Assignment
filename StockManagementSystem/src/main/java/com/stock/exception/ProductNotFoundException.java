package com.stock.exception;

public class ProductNotFoundException extends Exception {

	public ProductNotFoundException() {
		
	}
	
	public ProductNotFoundException(String message) {
		super(message);
	}
}
