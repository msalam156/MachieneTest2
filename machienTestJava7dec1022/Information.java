package com.nissan.machienTestJava7dec1022;

public class Information {

	//instance  variable
	private String ItemCode;
	private String ItemName;
	private int buyingPrice;
	private int sellingPrice;
	private String catagory;
	private double tax;
	private int quantity;

	// default constructor
	Information() {
	}

	// parametrized constructor
	public Information(String itemCode, String itemName) {
		this.ItemCode = itemCode;
		this.ItemName = itemName;
	}

	public String getItemCode() {
		return ItemCode;
	}

	public void setItemCode(String itemCode) {
		ItemCode = itemCode;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	@Override
	public String toString() {
		return "Information [ItemCode=" + ItemCode + ", ItemName=" + ItemName + "]";
	}

	public Information(String itemCode, String itemName, int buyingPrice, int sellingPrice, String catagory, double tax,
			int quantity) {
		ItemCode = itemCode;
		ItemName = itemName;
		this.buyingPrice = buyingPrice;
		this.sellingPrice = sellingPrice;
		this.catagory = catagory;
		this.tax = tax;
		this.quantity = quantity;
	}

	public int getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(int buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
