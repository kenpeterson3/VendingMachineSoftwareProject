package com.techelevator.view;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	VendingMachine sut;
	ChipProduct chips = new ChipProduct("Lays", new BigDecimal("1.00"));
	List<Product> newProductArray = new ArrayList<>();
	Map<String, List<Product>> vendingMachineInventory = new TreeMap<String, List<Product>>();

	@Before
	public void setUp() throws Exception {
		sut = new VendingMachine(vendingMachineInventory);
		newProductArray.add(chips);
		newProductArray.add(chips);
		newProductArray.add(chips);
		vendingMachineInventory.put("A1", newProductArray);
	}

	@Test
	public void feedMoneyTest() {
		sut.feedMoney(4);
		assertEquals(new BigDecimal("10.00"), sut.balance);
		sut.completeTransaction();
		sut.feedMoney(1);
		assertEquals(new BigDecimal("11.00"), sut.balance);
		sut.completeTransaction();
	}

	@Test
	public void purchaseAndBalanceTest() {
		sut.feedMoney(4);
		sut.purchase("A1");
		assertEquals(new BigDecimal("9.00"), sut.balance);
		sut.completeTransaction();
	}

	@Test
	public void brokeTest() {
		sut.purchase("A1");
		assertEquals(1, vendingMachineInventory.size());
		sut.completeTransaction();
	}

	@Test
	public void endTransaction() {
		sut.feedMoney(1);
		sut.purchase("A1");
		sut.completeTransaction();
		assertEquals(new BigDecimal("0.00"), sut.balance);
	}
}
