package com.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
