package com.stock.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import com.stock.dto.ProductDto;
import com.stock.model.Product;
import com.stock.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired 
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProductDto addNewProduct(ProductDto product) {
		
		Product p = modelMapper.map(product, Product.class);
		Product savedProduct  =productRepository.save(p);
		
		return modelMapper.map(savedProduct, ProductDto.class);
		
	}
	
	
}
