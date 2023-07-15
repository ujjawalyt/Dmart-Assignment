package com.stock.service;

import org.springframework.stereotype.Service;

import com.stock.dto.ProductDto;


@Service
public interface ProductService {

	public ProductDto addNewProduct(ProductDto product);
}
