package com.techelevator.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VendingMachine {
	BigDecimal balance = new BigDecimal(0.00).setScale(2);
	List<Product> purchaseList = new ArrayList<>();
	Map<String, List<Product>> inventory = new TreeMap<>();
	LogWriter writer = new LogWriter();

	public VendingMachine(Map<String, List<Product>> inventory) {
		this.inventory = inventory;
	}

	public void displayInventory() {
		for (Map.Entry<String, List<Product>> entry : inventory.entrySet()) {
			String key = entry.getKey();
			List value = entry.getValue();
			if (value.size() == 1) {
				System.out.println(key + " Out of stock");
			} else {

			}
			System.out.println(key + " " + value.subList(0, 1) + " " + (value.size() - 1));
		}
	}

	public void feedMoney(int addMoney) {
		String typeOfTransaction = "FEED MONEY:";
		if (addMoney == 1) {
			balance = balance.add(new BigDecimal(1.00));
			writer.writer(typeOfTransaction, new BigDecimal(1.00).setScale(2), balance);

		} else if (addMoney == 2) {
			balance = balance.add(new BigDecimal(2.00));
			writer.writer(typeOfTransaction, new BigDecimal(2.00).setScale(2), balance);
		} else if (addMoney == 3) {
			balance = balance.add(new BigDecimal(5.00));
			writer.writer(typeOfTransaction, new BigDecimal(5.00).setScale(2), balance);
		} else if (addMoney == 4) {
			balance = balance.add(new BigDecimal(10.00));
			writer.writer(typeOfTransaction, new BigDecimal(10.00).setScale(2), balance);
		}
		System.out.println("Your balance is " + balance);
	}

	public void completeTransaction() {
		Change thisChange = new Change();
		thisChange.giveChange(balance);
		writer.writer("GIVE CHANGE:", balance, new BigDecimal(0.00).setScale(2));
		while (purchaseList.size() > 0) {
			Product purchases = purchaseList.remove(0);
			System.out.println(purchases.getSound());
		}
	}

	public void purchase(String guestSelection) {
		if (! inventory.containsKey(guestSelection)) { 
			System.out.println("Sorry that product does not exist, please choose a valid product");
		} 
		if (inventory.containsKey(guestSelection)) {
			if (inventory.get(guestSelection).size() == 1) {
				System.out.println("Sorry out of stock");
			}
			if (inventory.get(guestSelection).size() >= 1) {
				if (balance.compareTo(inventory.get(guestSelection).get(0).price) >= 0) {
					balance = balance.subtract(inventory.get(guestSelection).get(0).price);
					Product p = inventory.get(guestSelection).remove(0);
					purchaseList.add(p);
					Product cost = inventory.get(guestSelection).get(1);
					BigDecimal costOne = cost.price;
					Product nameOne = inventory.get(guestSelection).get(0);
					String productOne = nameOne.name + " " + guestSelection;
					writer.writer(productOne, costOne, balance);
				} else {
					System.out.println("Your out of luck Joe, insert some cash Yo!");
				}
			}
		}
		System.out.println("Your balance is " + balance);
	}
}
