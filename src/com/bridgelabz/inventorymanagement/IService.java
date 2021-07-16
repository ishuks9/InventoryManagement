package com.bridgelabz.inventorymanagement;

import org.json.simple.JSONObject;
public interface IService {
	public JSONObject addDetails();
	public void readFile();
	public double totalWeight();
    public double totalPrice();
	public double price(String item);
}

