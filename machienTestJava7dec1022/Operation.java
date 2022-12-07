package com.nissan.machienTestJava7dec1022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operation {
	// make scanner static and public for use to all methods
	public static Scanner scanner = new Scanner(System.in);

	// create a List that store Item details
	 public static List<Information> list = new ArrayList<>();

	// declare PIN
	static final int PIN = 1;

	public static void main(String[] arg) {
		// start application with Authentication
		checkAuthenticaton();
	}

	// Method to Authenticate the user
	public static void checkAuthenticaton() {
		System.out.println("Enter the PIN");
		try {
			int checkPin = scanner.nextInt();
			if (checkPin == PIN) {
				// if(true) {
				System.out.println(
						"-`-`-`-`-`-`-`-`-`-`-`-``-`-`-`-`-`  Welcome to Mukeet Store-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`");
				// after checking user invoking operation method
				operations();
			} else
				System.out.println("Please Enter Correct PIN");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void operations() {
		// ask user to choose the option 1 to 4
		System.out.println("************************Operations *********************************");
		System.out.println("Press 1 for Adding Itmes \n" + "Press 2 for Search Itmes \n" + "Press 3 for Show all Item\n"
				+ "Press 4 for EXIT");
		try {
			// taking input from user for options
			int checkOption = scanner.nextInt();

			if (checkOption == 1) {
				// adding to the list
				addItem();
			} else if (checkOption == 2) {
				// Search in the List
				System.out.println("Enter the item code tha You want to search: ");
				String itemCd = scanner.next();// taking itemCode from the user
				searchItme(itemCd); // pass itemCd to searchItem as a argument
			} else if (checkOption == 3) {
				// Show All items int the list
				showAlltem();
			} else if (checkOption == 4) {
				// exit logic
				System.out.println("Bye Bye ");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void addItem() {
		
		do { // do while for continuity
			// taking input from user
			try {
				System.out.println("Enter the item Code : ");
				String itmCode = scanner.next();
				System.out.println("Enter the item Name : ");
				String itmName = scanner.next();
				System.out.println("Enter the buyingPrice : ");
				int buyingPrice = scanner.nextInt();
				System.out.println("Enter the sellingPrice : ");
				int sellingPrice = scanner.nextInt();
				System.out.println("Enter the catagory : ");
				String catagory = scanner.next();
				System.out.println("Enter the tax : ");
				double tax = scanner.nextDouble();
				System.out.println("Enter the quantity: ");
				int quantity = scanner.nextInt();

				// first chekc in the list or not
				// String str = list.get(0).getItemCode() ;
				if (isAvalable(list, itmCode)) {
					// add item to the list
					list.add(new Information(itmCode, itmName, buyingPrice, sellingPrice, catagory, tax, quantity));
				} else
					System.out.println("This item is Already Exist in the store");

			} catch (Exception e) {
				System.out.println("Please Enter valid input " + e);
			}
			// ask user to continue or not
			System.out.println("Please Enter 1 for continue and press 2 for Exit and Back to Operations ");
			int option = scanner.nextInt();
			if (option == 1)
				continue;
			else if (option == 2) {
				operations();
				break;
			}
		} while (true);

	}

	public static void showAlltem() {
		System.out.println("**********************Welcome to Mukeet Wherouse ***************************");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Item Code : " + list.get(i).getItemCode());
			System.out.println("Item Name : " + list.get(i).getItemName());
			System.out.println("Buing Price : " + list.get(i).getBuyingPrice());
			System.out.println("Selling Price : " + list.get(i).getSellingPrice());
			System.out.println("Catagory : " + list.get(i).getCatagory());
			System.out.println("Tax : " + list.get(i).getTax());
			System.out.println("Quantity : " + list.get(i).getQuantity());
		}
		try {
			System.out.println("Press 2 for go back to the menu");
			int gotoOperation = scanner.nextInt();
			if (gotoOperation == 2)
				operations();
		} catch (Exception e) {
			System.out.println("Please enter Valid input" + e);
		}
	}

	public static void searchItme(String searchItem) {
		// for continuity add do while

		do {
			System.out.println("************************** Searched Item ****************************");
			boolean flag = true; // for checking
			for (int i = 0; i < list.size(); i++) {// traverse the list
				if (list.get(i).getItemCode().equals(searchItem)) {// check itemCode is Exist or not
					flag = false; // change the flag for something else follow up
					// print all the values
					System.out.println("Item Code : " + list.get(i).getItemCode());
					System.out.println("Item Name : " + list.get(i).getItemName());
					System.out.println("Buing Price : " + list.get(i).getBuyingPrice());
					System.out.println("Selling Price : " + list.get(i).getSellingPrice());
					System.out.println("Catagory : " + list.get(i).getCatagory());
					System.out.println("Tax : " + list.get(i).getTax());
					System.out.println("Quantity : " + list.get(i).getQuantity());
				}
			}
			// if flag does not change their value so show that message
			if (flag)
				System.out.println("There is no data related to this item code");
			System.out.println("If you want to  go back Press 2 \n" + "Press 1 for continue");
			try {
				int doContinue = scanner.nextInt();
				if (doContinue == 1)
					continue;
				else if (doContinue == 2) {
					operations();
				} else
					System.out.println("Please enter in between 1 or 2");

			} catch (Exception e) {
				System.out.println("Please enter valid Inpur" + e);
			}
		} while (true);

	}

	// check item it is already in or not
	public static boolean isAvalable(List<Information> list, String code) {
		if (list.size() == 0)
			return true;
		if (list.get(0).getItemCode().equals(code))
			return false;// comparing two objects
		return true;
	}

}
