package com.stock.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.dto.StockItemDto;
import com.stock.exception.ProductNotFoundException;
import com.stock.exception.StockNotFoundException;
import com.stock.model.Product;
import com.stock.model.StockItem;
import com.stock.repository.ProductRepository;
import com.stock.repository.StockItemRepository;

@Service
public class StockItemSeviceImpl implements StockItemService {

	@Autowired
	private StockItemRepository stockItemRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StockItemDto addNewProductToStock(StockItemDto stockItemDto, Long productId)
			throws ProductNotFoundException {

		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Product not found By this productId" + productId));

		StockItem stockItem = modelMapper.map(stockItemDto, StockItem.class);

		stockItem.setName(product.getProductName());
		stockItem.setProduct(product);
		StockItem savedStockItem = stockItemRepository.save(stockItem);
		return modelMapper.map(savedStockItem, StockItemDto.class);
	}

	@Override
	public String deleteStock(Long stockId) throws StockNotFoundException {

		StockItem stockItem = stockItemRepository.findById(stockId)
				.orElseThrow(() -> new StockNotFoundException("stock not found by this stock id" + stockId));

		stockItem.setProduct(null);
		stockItemRepository.delete(stockItem);
		return "Stock Delete Successfully";

	}

	@Override
	public StockItemDto updateNewProductToStock(Long stockId, StockItemDto stockItemDto) throws StockNotFoundException {

		StockItem stockItem = stockItemRepository.findById(stockId)
				.orElseThrow(() -> new StockNotFoundException("Stock not found with stock id: " + stockId));

		stockItem.setQuantity(stockItemDto.getQuantity()+stockItem.getQuantity());

		StockItem updatedStockItem = stockItemRepository.save(stockItem);

		return modelMapper.map(updatedStockItem, StockItemDto.class);

	}

	@Override
	public List<StockItemDto> getAllStockItem() throws StockNotFoundException {
		
		 List<StockItem> stockItems = stockItemRepository.findAll();
		    if (stockItems.isEmpty()) {
		        throw new StockNotFoundException("No stock items found.");
		    }

		    return stockItems.stream()
		            .map(stockItem -> modelMapper.map(stockItem, StockItemDto.class))
		            .collect(Collectors.toList());
	}
}
