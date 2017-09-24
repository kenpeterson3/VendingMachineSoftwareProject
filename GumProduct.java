package com.techelevator.view;

import java.math.BigDecimal;

public class GumProduct extends Product{

		public GumProduct(String name, BigDecimal price) {
		super(name, price);
		
	}

		public String getSound() {
			return "Chew Chew, Yum!";
		}
}
