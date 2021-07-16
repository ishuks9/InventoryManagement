package com.bridgelabz.inventorymanagement;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ServicesImplementation implements IService{
private static final String INVENTORY_FILE = "C:/Users/admin/Documents/inventry.json";
	
	/**
	 * Define function to add details in the Inventory Data System
	 * 
	 * @return JSONObject
	 */
	
	
	@SuppressWarnings("unchecked")
	public JSONObject addDetails() 
	{
		JSONObject object = new JSONObject();

		System.out.print("Enter a name : ");
		String name = InputUtility.inputString();

		System.out.print("Enter a price : ");
		double price = InputUtility.inputDouble();

		System.out.print("Enter a weight(in kg) :");
		double weight = InputUtility.inputDouble();

		object.put("Name", name);
		object.put("Price", price);
		object.put("Weight", weight);

		return object;
	}

	/**
	 * Define function to read the data from Inventory Data System
	 */
	public void readFile() {
		String string = Utility.readFromFile(INVENTORY_FILE);
		JSONParser parser = new JSONParser();

		JSONObject objectFile = null;
		try 
		{
			objectFile = (JSONObject) parser.parse(string);
			System.out.printf("Rice Details %s", objectFile.get("Rice"));
			System.out.println();
			System.out.printf("Pulses Details %s", objectFile.get("Pulses"));
			System.out.println();
			System.out.printf("Wheats Details %s", objectFile.get("Wheats"));
			System.out.println();
		} 
		catch (ParseException e) 
		{
			System.out.println(e.getStackTrace());
		}

		
	}

	/**
	 * define function to calculate the total weight of items in Inventory Data
	 * System
	 * 
	 * @return double
	 */
	public double totalWeight() 
	{
		double totalWeight = 0;

		// reading a data from file
		String stringFile = Utility.readFromFile("C:/Users/admin/Documents/inventry.json");
		// creating a JSONParser object
		JSONParser parser = new JSONParser();

		JSONObject objectFile = null;
		try 
		{
			objectFile = (JSONObject) parser.parse(stringFile);
			JSONObject riceObject = (JSONObject) objectFile.get("Rice");
			double riceWeight = (double) riceObject.get("Weight");

			JSONObject pulsesObject = (JSONObject) objectFile.get("Pulses");
			double pulsesWeight = (double) pulsesObject.get("Weight");

			JSONObject wheatsObject = (JSONObject) objectFile.get("Wheats");
			double wheatsWeight = (double) wheatsObject.get("Weight");

			totalWeight = riceWeight + pulsesWeight + wheatsWeight;
		} 
		catch (ParseException e) 
		{
			System.out.println();
		}

		

		return totalWeight;
	}

	/**
	 * define function to calculate the total price of items
	 * 
	 * @return double
	 */
	public double totalPrice() {
		double totalPrice = 0;
		// reading a data from file
		String stringFile = Utility.readFromFile("C:/Users/admin/Documents/inventry.json");
		// creating a JSONParser object
		JSONParser parser = new JSONParser();

		JSONObject objectFile = null;
		try 
		{
			objectFile = (JSONObject) parser.parse(stringFile);
			JSONObject riceObject = (JSONObject) objectFile.get("Rice");
			double ricePrice = (double) riceObject.get("Price");
			double riceWeight = (double) riceObject.get("Weight");

			JSONObject pulsesObject = (JSONObject) objectFile.get("Pulses");
			double pulsesPrice = (double) pulsesObject.get("Price");
			double pulsesWeight = (double) pulsesObject.get("Weight");

			JSONObject wheatsObject = (JSONObject) objectFile.get("Wheats");
			double wheatsPrice = (double) wheatsObject.get("Price");
			double wheatsWeight = (double) wheatsObject.get("Weight");

			totalPrice = (ricePrice * riceWeight) + (pulsesPrice * pulsesWeight) + (wheatsPrice * wheatsWeight);
		}
		catch (ParseException e) 
		{
			System.out.println(e.getStackTrace());
		}

		
		return totalPrice;
	}

	/**
	 * define function to fetch the price of item
	 * 
	 * @param item ==>String
	 * @return double
	 */
	public double price(String item) 
	{

		String itemRice = "Rice";
		int rice = itemRice.compareToIgnoreCase(item);
		String itemWheats = "Wheats";
		int wheats = itemWheats.compareToIgnoreCase(item);
		String itemPulses = "Pulses";
		int pulses = itemPulses.compareToIgnoreCase(item);

		// reading a data from file
		String stringFile = Utility.readFromFile("Inventory.json");

		// creating a JSONParser object
		JSONParser parser = new JSONParser();

		JSONObject objectFile = null;
		try 
		{
			objectFile = (JSONObject) parser.parse(stringFile);
		} 
		catch (ParseException e) 
		{
			System.out.println(e.getStackTrace());
		}
		double itemPrice = 0;
		if (rice == 0) 
		{
			JSONObject itemObject = (JSONObject) objectFile.get("Rice");
			itemPrice = (double) itemObject.get("Price");
			return itemPrice;
		}
		if (pulses == 0) 
		{
			JSONObject itemObject = (JSONObject) objectFile.get("Pulses");
			itemPrice = (double) itemObject.get("Price");
			return itemPrice;
		}
		if (wheats == 0) 
		{
			JSONObject itemObject = (JSONObject) objectFile.get("Wheats");
			itemPrice = (double) itemObject.get("Price");
			return itemPrice;
		}
		return 0;
	}


}
