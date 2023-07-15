package com.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@PostMapping("/add/product/{productId}")
	public ResponseEntity<StockItemDto> addNewStock(@RequestBody StockItemDto stockItemDto , Long ProductId)throws
	ProductNotFoundException{
		return new ResponseEntity<StockItemDto>(stockItemService.addNewProductToStock(stockItemDto, ProductId),HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/delete/{stockId}")
	public ResponseEntity<String > deleteStockById(@PathVariable("stockId") Long stockId) throws StockNotFoundException{
		
		return new ResponseEntity<String>(stockItemService.deleteStock(stockId),HttpStatus.OK);
	}
	
	@PutMapping("/update/{stockId}")
	public ResponseEntity<StockItemDto> updateStockItem(@PathVariable("stockId") Long stockId, @RequestBody StockItemDto stockItemDto)
			throws StockNotFoundException{
		
		return new ResponseEntity<StockItemDto>(stockItemService.updateNewProductToStock(stockId, stockItemDto),HttpStatus.ACCEPTED);
	}
}
