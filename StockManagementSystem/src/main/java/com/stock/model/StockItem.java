package com.stock.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class StockItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stockId;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int quantity;
	
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    
    @OneToMany(mappedBy = "stockItem", cascade = CascadeType.ALL)
    private List<StockMovement> stockMovements = new ArrayList<>();

	
}
