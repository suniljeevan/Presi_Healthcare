package com.pres.Pharmacy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import lombok.Setter;

import com.pres.Pharmacy.model.*;



@AllArgsConstructor
@Data
@Entity
@Table(name="Inventory")
public class PharmacyInventory {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;
	
    @Column(name="product_Name",nullable=false)
	private String productName;

    @Column(name="quantity",nullable=false)
	private int quantity;

    @Column(name="price",nullable=false)
	private double price;

    @ManyToOne
    @JoinColumn(name = "pharmacyId")
    private Pharmacy pharmacy;

    public PharmacyInventory() {
    }


    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    

    
    
}
