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

	/**
	 * 
	 * Moves stock items from one location to another.
	 * 
	 * @param stockId       The ID of the stock item to be moved.
	 * @param locationId    The ID of the current location of the stock item.
	 * @param destinationId The ID of the destination location for the stock item.
	 * @param quantity      The quantity of stock items to be moved.
	 * @return A ResponseEntity object containing the details of the stock movement.
	 * @throws StockNotFoundException     If the specified stock item is not found.
	 * @throws StoreLocationNotFound      If either the current location or the
	 *                                    destination location is not found.
	 * @throws InsufficientStockException If there is not enough stock available at
	 *                                    the current location to fulfill the
	 *                                    movement.
	 */

	@PostMapping("/stockId{stockId}/location{locationId}/destination/{destinationId}/noOfQuantity/{quantity}")
	public ResponseEntity<StockMovement> moveStockItem(@PathVariable("stockId") Long stockId,
			@PathVariable("locationId") Long locationId, @PathVariable("destinationId") Long destinationId,
			@PathVariable("quantity") int quantity)
			throws StockNotFoundException, StoreLocationNotFound, InsufficientStockException {

		return new ResponseEntity<StockMovement>(
				stockMovementService.moveStockItem(stockId, locationId, destinationId, quantity), HttpStatus.CREATED);
	}
}
