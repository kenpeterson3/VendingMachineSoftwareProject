package com.techelevator.view;

import java.math.BigDecimal;

public class DrinkProduct extends Product {

	public DrinkProduct(String name, BigDecimal price) {
		super(name, price);

	}

	public String getSound() {
		return "Glug Glug, Yum!";
	}
}
