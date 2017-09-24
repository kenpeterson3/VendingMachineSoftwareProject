package com.techelevator.view;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class DrinkProductTest {
	DrinkProduct sut;

	@Before
	public void setUp() throws Exception {
		sut = new DrinkProduct("Coke", new BigDecimal("1.50"));
	}

	@Test
	public void testConstructor() {

		assertEquals("Coke", sut.getName());
		assertEquals("1.50", sut.getPrice().toString());
	}
}
