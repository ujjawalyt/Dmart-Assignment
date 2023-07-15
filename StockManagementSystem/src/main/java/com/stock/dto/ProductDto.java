package com.stock.dto;

import org.springframework.boot.autoconfigure.AutoConfiguration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

	
	private String productName;
    private double price;
    private String description;
}
