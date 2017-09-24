package com.techelevator.view;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class StockReaderTest {
	StockReader sut;

	@Test
	public void testFileimporter() {

		sut = new StockReader();
		Map<String, List<Product>> testMap = sut.fileImporter();

		Product p = testMap.get("A1").get(0);
		assertEquals("Potato Crisps", p.getName());
		assertEquals(new BigDecimal("3.05"), p.getPrice());
		assertEquals(true, testMap.containsKey("A1"));
	}
}
