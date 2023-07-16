package com.stock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stock.dto.StockItemDto;
import com.stock.exception.ProductNotFoundException;
import com.stock.exception.StockNotFoundException;

@Service
public interface StockItemService {

	public StockItemDto addNewProductToStock(StockItemDto stockItemDto,Long productId) 
			throws ProductNotFoundException;
	
	public String deleteStock(Long stockId) throws StockNotFoundException;
	
	public StockItemDto updateNewProductToStock(Long stockId, StockItemDto stockItemDto ) throws StockNotFoundException;

	public List<StockItemDto> getAllStockItem()  throws StockNotFoundException;

}
