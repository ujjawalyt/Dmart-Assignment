package com.stock.exception;

public class InsufficientStockException extends Exception {

	public InsufficientStockException() {
		
	}
	public InsufficientStockException(String message) {
	 super(message);
	}
}
