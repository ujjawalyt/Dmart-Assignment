package com.stock.service;

import org.springframework.stereotype.Service;

import com.stock.dto.StoreLocationDto;

@Service
public interface StoreLocationService {

	public StoreLocationDto addNewLocation(StoreLocationDto storeLocationDto);
}
