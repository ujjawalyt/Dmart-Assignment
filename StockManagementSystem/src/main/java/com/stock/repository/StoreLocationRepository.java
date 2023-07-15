package com.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.model.StoreLocation;

public interface StoreLocationRepository extends JpaRepository<StoreLocation, Long> {

}
