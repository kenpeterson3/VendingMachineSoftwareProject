package com.techelevator.view;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class CandyProductTest {
CandyProduct sut;

	@Before
	public void setUp() throws Exception { 
		sut = new CandyProduct("HersheyBar", new BigDecimal("1.50"));	
	}

	@Test
	public void testConstructor() {
		
			assertEquals("HersheyBar", sut.getName());			
			assertEquals("1.50", sut.getPrice().toString());	
	}
}
