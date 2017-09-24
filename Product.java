package com.techelevator.view;

import java.math.BigDecimal;

public abstract class Product {

	public String name;
	public BigDecimal price;

	public Product(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public abstract String getSound();

	@Override
	public String toString() {
		String result = name + " " + price;
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
