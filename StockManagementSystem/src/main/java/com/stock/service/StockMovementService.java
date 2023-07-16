package com.stock.service;

import com.stock.exception.InsufficientStockException;
import com.stock.exception.StockNotFoundException;
import com.stock.exception.StoreLocationNotFound;
import com.stock.model.StockMovement;

public interface StockMovementService {

	
	 public StockMovement moveStockItem(Long stockItemId, Long sourceLocationId, Long destinationLocationId, int  quantity) throws 
	 StoreLocationNotFound, StockNotFoundException,InsufficientStockException;
}
