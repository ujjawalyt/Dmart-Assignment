package com.stock.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long productId;
	
	@Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private String description;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<StockItem> stocks = new ArrayList<>();

}
