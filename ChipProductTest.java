package com.techelevator.view;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class ChipProductTest {
	ChipProduct sut;

	@Before
	public void setUp() throws Exception {
		sut = new ChipProduct("Lays", new BigDecimal("1.50"));
	}

	@Test
	public void testConstructor() {

		assertEquals("Lays", sut.getName());
		assertEquals("1.50", sut.getPrice().toString());
	}
}
