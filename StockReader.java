package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StockReader {

	public Map<String, List<Product>> fileImporter() {
		File inventoryFile = new File("/Users/kenpeterson/workspace/team7-java-module1-capstone/vendingmachine.csv");

		Map<String, List<Product>> vendingMachineInventory = new TreeMap<>();

		try (Scanner stockImporter = new Scanner(inventoryFile)) {
			while (stockImporter.hasNextLine()) {
				String line = stockImporter.nextLine();
				if (!line.isEmpty()) {
					String[] stockImporterArray = line.split("\\|");

					if (stockImporterArray[0].contains("A")) {
						List<Product> productArray = new ArrayList<>();
						for (int i = 0; i < 6; i++) {
							ChipProduct temp = new ChipProduct(stockImporterArray[1], new BigDecimal(stockImporterArray[2]));
							productArray.add(temp);
						}
						vendingMachineInventory.put(stockImporterArray[0], productArray);


					} else if (stockImporterArray[0].contains("B")) {
						List<Product> productArray = new ArrayList<>();
						for (int i = 0; i < 6; i++) {
							CandyProduct temp = new CandyProduct(stockImporterArray[1], new BigDecimal(stockImporterArray[2]));
							productArray.add(temp);
						}
						vendingMachineInventory.put(stockImporterArray[0], productArray);

					} else if (stockImporterArray[0].contains("C")) {
						List<Product> productArray = new ArrayList<>();
						for (int i = 0; i < 6; i++) {

							DrinkProduct temp = new DrinkProduct(stockImporterArray[1], new BigDecimal(stockImporterArray[2]));
							productArray.add(temp);
						}
						vendingMachineInventory.put(stockImporterArray[0], productArray);

					} else {
						List<Product> productArray = new ArrayList<>();

						for (int i = 0; i < 6; i++) {
							GumProduct temp = new GumProduct(stockImporterArray[1], new BigDecimal(stockImporterArray[2]));
							productArray.add(temp);
						}
						vendingMachineInventory.put(stockImporterArray[0], productArray);
					}
				}
			}
			return vendingMachineInventory;

		} catch (FileNotFoundException e) {
			System.out.println("Your file does not exist");
			System.exit(1);
			return vendingMachineInventory;
		}
	}
}
