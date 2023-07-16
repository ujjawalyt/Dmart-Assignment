package com.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.dto.StockItemDto;
import com.stock.exception.ProductNotFoundException;
import com.stock.exception.StockNotFoundException;
import com.stock.repository.StockItemRepository;
import com.stock.service.StockItemService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/stockItem")
public class StockItemController {

	@Autowired
	private StockItemService stockItemService;

	/**
	 * Adds a new stock item for a specific product.
	 * 
	 * @param stockItemDto The StockItemDto object containing the details of the
	 *                     stock item to be added.
	 * @param productId    The ID of the product the stock item belongs to.
	 * @return A ResponseEntity object containing the created stock item
	 *         information.
	 * @throws ProductNotFoundException If the specified product is not found.
	 */
	@PostMapping("/add/product/{productId}")
	public ResponseEntity<StockItemDto> addNewStock(@RequestBody StockItemDto stockItemDto, Long ProductId)
			throws ProductNotFoundException {
		return new ResponseEntity<StockItemDto>(stockItemService.addNewProductToStock(stockItemDto, ProductId),
				HttpStatus.CREATED);
	}

	/**
	 * 
	 * Deletes a stock item by its ID.
	 * 
	 * @param stockId The ID of the stock item to be deleted.
	 * @return A ResponseEntity object with a String indicating the success of the
	 *         deletion.
	 * @throws StockNotFoundException If the specified stock item is not found.
	 */

	@DeleteMapping("/delete/{stockId}")
	public ResponseEntity<String> deleteStockById(@PathVariable("stockId") Long stockId) throws StockNotFoundException {

		return new ResponseEntity<String>(stockItemService.deleteStock(stockId), HttpStatus.OK);
	}

	/**
	 * 
	 * Updates a stock item by its ID.
	 * 
	 * @param stockId      The ID of the stock item to be updated.
	 * @param stockItemDto The StockItemDto object containing the updated details of
	 *                     the stock item.
	 * @return A ResponseEntity object containing the updated stock item
	 *         information.
	 * @throws StockNotFoundException If the specified stock item is not found.
	 */

	@PutMapping("/update/{stockId}")
	public ResponseEntity<StockItemDto> updateStockItem(@PathVariable("stockId") Long stockId,
			@RequestBody StockItemDto stockItemDto) throws StockNotFoundException {

		return new ResponseEntity<StockItemDto>(stockItemService.updateNewProductToStock(stockId, stockItemDto),
				HttpStatus.ACCEPTED);
	}

	/**
	 * 
	 * Retrieves all stock items.
	 * 
	 * @return A ResponseEntity object containing a list of StockItemDto objects
	 *         representing all the stock items.
	 * @throws StockNotFoundException If no stock items are found.
	 */

	@GetMapping("/")
	public ResponseEntity<List<StockItemDto>> getAllStockItems() throws StockNotFoundException {

		return new ResponseEntity<List<StockItemDto>>(stockItemService.getAllStockItem(), HttpStatus.ACCEPTED);
	}
}
