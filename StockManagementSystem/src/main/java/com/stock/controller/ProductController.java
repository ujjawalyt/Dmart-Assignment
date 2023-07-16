package com.stock.controller;

import javax.persistence.PostLoad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.dto.ProductDto;
import com.stock.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	/**
	Adds a new product.
	@param product The ProductDto object containing the details of the product to be added.
	@return A ResponseEntity object containing the created product information.
	*/
	
	@PostMapping("/save")
	public ResponseEntity<ProductDto> addNewProduct(@RequestBody ProductDto product){
		
		return new ResponseEntity<ProductDto>(productService.addNewProduct(product),HttpStatus.CREATED);
	}
	
}
