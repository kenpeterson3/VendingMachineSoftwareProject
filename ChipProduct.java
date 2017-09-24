package com.techelevator.view;

import java.math.BigDecimal;

public class ChipProduct extends Product {
	
	public ChipProduct(String name, BigDecimal price) {
		super(name, price);
		
	}

	public  String getSound() {
		return "Crunch Crunch, Yum!";
	}
}
