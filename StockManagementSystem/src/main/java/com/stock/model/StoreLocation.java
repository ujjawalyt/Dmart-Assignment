package com.stock.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
public class StoreLocation {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    private String storeName;
    private String address;
    private String phoneNo;
    private String city;
    private String state;
    
    
    @OneToMany(mappedBy = "sourceLocation", cascade = CascadeType.ALL)
    private List<StockMovement> sourceStockMovements = new ArrayList<>();

    @OneToMany(mappedBy = "destinationLocation", cascade = CascadeType.ALL)
    private List<StockMovement> destinationStockMovements = new ArrayList<>();
    
}
