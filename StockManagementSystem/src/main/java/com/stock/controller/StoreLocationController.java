package com.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.dto.StoreLocationDto;
import com.stock.service.StoreLocationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/stockLocation")
public class StoreLocationController {

	@Autowired
	private StoreLocationService storeLocationService;

	@PostMapping("/save")
	public ResponseEntity<StoreLocationDto> addNewLocation(@RequestBody StoreLocationDto storeLocationDto) {

		return new ResponseEntity<StoreLocationDto>(storeLocationService.addNewLocation(storeLocationDto),
				HttpStatus.CREATED);
	}

}
