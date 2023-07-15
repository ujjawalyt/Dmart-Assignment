package com.stock.exception;

public class StockNotFoundException extends Exception {

	public StockNotFoundException() {

	}

	public StockNotFoundException(String message) {
		super(message);
	}
}
