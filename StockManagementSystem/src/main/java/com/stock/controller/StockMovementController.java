package com.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.exception.InsufficientStockException;
import com.stock.exception.StockNotFoundException;
import com.stock.exception.StoreLocationNotFound;
import com.stock.model.StockMovement;
import com.stock.service.StockMovementService;

@RestController
@RequestMapping("stock/")
public class StockMovementController {

	
	@Autowired
	private StockMovementService stockMovementService;
	
	@PostMapping("/stockId{stockId}/location{locationId}/destination/{destinationId}/noOfQuantity/{quantity}")
		public ResponseEntity<StockMovement> moveStockItem(@PathVariable("stockId") Long stockId,
				@PathVariable("locationId") Long locationId,
				@PathVariable("destinationId") Long destinationId,
				@PathVariable("quantity") int quantity
				) throws StockNotFoundException, StoreLocationNotFound,InsufficientStockException{
			
			return new ResponseEntity<StockMovement>
			(stockMovementService.moveStockItem(stockId, locationId, destinationId, quantity),HttpStatus.CREATED);
		}
	}

