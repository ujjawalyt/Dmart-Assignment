package com.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreLocationDto {

	 private String storeName;
	    private String address;
	    private String phoneNo;
	    private String city;
	    private String state;
	
}
