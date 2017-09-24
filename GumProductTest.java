package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.view.GumProduct;

public class GumProductTest {
	GumProduct sut;

	@Before
	public void setUp() throws Exception {
		sut = new GumProduct("JuicyFruit", new BigDecimal("1.50"));
	}

	@Test
	public void testConstructor() {

		assertEquals("JuicyFruit", sut.getName());
		assertEquals("1.50", sut.getPrice().toString());
	}
}
