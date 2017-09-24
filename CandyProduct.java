package com.techelevator.view;

import java.math.BigDecimal;

public class CandyProduct extends Product  {
	
	public CandyProduct(String name, BigDecimal price) {
		super(name, price);
		
	}

	public String getSound() {
		return "Munch Munch, Yum";
	}


	
}
