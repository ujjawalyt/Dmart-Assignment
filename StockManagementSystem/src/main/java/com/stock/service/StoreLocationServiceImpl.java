package com.stock.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.dto.StoreLocationDto;
import com.stock.model.StoreLocation;
import com.stock.repository.StoreLocationRepository;

@Service
public class StoreLocationServiceImpl implements StoreLocationService {
 
	@Autowired
	private StoreLocationRepository storeLocationRepository;
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public StoreLocationDto addNewLocation(StoreLocationDto storeLocationDto) {
	
		StoreLocation storeLocation = modelMapper.map(storeLocationDto, StoreLocation.class);
		
		StoreLocation savedLocation = storeLocationRepository.save(storeLocation);
		
		return modelMapper.map(savedLocation, StoreLocationDto.class);
	}
	
	
}
