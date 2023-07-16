package com.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.exception.InsufficientStockException;
import com.stock.exception.StockNotFoundException;
import com.stock.exception.StoreLocationNotFound;
import com.stock.model.StockItem;
import com.stock.model.StockMovement;
import com.stock.model.StoreLocation;
import com.stock.repository.StockItemRepository;
import com.stock.repository.StockMovementRepository;
import com.stock.repository.StoreLocationRepository;

@Service
public class StockMovementServiceImpl implements StockMovementService {

	@Autowired
	private StockMovementRepository stockMovementRepository;
	@Autowired
	private StockItemRepository stockItemRepository;
	@Autowired
	private StoreLocationRepository storeLocationRepository;
	

	@Override
	public StockMovement moveStockItem(Long stockItemId, Long sourceLocationId, Long destinationLocationId,int  quantity)
			throws StoreLocationNotFound, StockNotFoundException ,InsufficientStockException {
	
	
		StockItem stockItem = stockItemRepository.findById(stockItemId)
	            .orElseThrow(() -> new StockNotFoundException("Stock item not found"));

	    if (stockItem.getQuantity() < quantity) {
	        throw new InsufficientStockException("Insufficient stock quantity");
	    }

	    StoreLocation sourceLocation = storeLocationRepository.findById(sourceLocationId)
	            .orElseThrow(() -> new StoreLocationNotFound("Source location not found"));

	    StoreLocation destinationLocation = storeLocationRepository.findById(destinationLocationId)
	            .orElseThrow(() -> new StoreLocationNotFound("Destination location not found"));

	    StockMovement stockMovement = new StockMovement();
	    stockMovement.setStockItem(stockItem);
	    stockMovement.setSourceLocation(sourceLocation);
	    stockMovement.setDestinationLocation(destinationLocation);
	    stockMovement.setNoOfQuantity(quantity);

	
	    stockItem.setQuantity(stockItem.getQuantity() - quantity);
	    stockItemRepository.save(stockItem);

	    return stockMovementRepository.save(stockMovement);
	}
	
	
}
