package com.bridgelabz.inventorymanagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Utility {
	private static Scanner scanner = new Scanner(System.in);
	private static BufferedReader bufferReader;

	private Utility()
	{
		//not called
	}

	//To take Integer input
	public static int inputInteger()
	{
		return scanner.nextInt();
	}
	public static long inputLong()
	{
		return scanner.nextLong();
	}
	public static boolean checkNext()
	{
		return scanner.hasNext();
	}
	//To take Double input
	public static double inputDouble()
	{
		return scanner.nextDouble();
	}
	//To take Float input
	public static float inputFloat()
	{
		return scanner.nextFloat();
	}
	//To take String input
	public static String inputString()
	{
		return scanner.next();
	}
	//To take String input
	public static String inputStringLine()
	{
		return scanner.nextLine();
	}
/***********************************Creating and Writing into File******************************************/
	
	/**
	 * 
	 * @param filename --> String type
	 * @param data --> String Type
	 * @return --> boolean
	 */
	
	public static boolean writeToFile(String filename, String data) 
	{
		File file = new File(filename);
		BufferedWriter bw = null;
		if (!file.exists()) 
		{
			try
			{
				if(file.createNewFile())
					System.out.println("File Created Succcessfully");
				else
					System.out.println("File Already Exists");
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}

		try 
		{
			bw = new BufferedWriter(new FileWriter(new File(filename)));
			bw.write(data);
			bw.flush();
			bw.close();

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		return true;
	}
	
	
	/***********************************Read From File******************************************/
	
	
	/**
	 * 
	 * @param filename --> String type
	 * @return --> String
	 */
	
	public static String readFromFile(String filename) 
	{

		try
		{

			bufferReader = new BufferedReader(new FileReader(filename));

		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Error in Loading Reader"+e.getMessage());
		}

		StringBuilder sb = new StringBuilder();

		try 
		{
			String line;
			while ((line = bufferReader.readLine()) != null) //append until file pointer reaches to null
				sb.append(line);

		}
		catch (IOException e) 
		{
			System.out.println("File is Empty:  " + e.getMessage());
		} 
		finally 
		{
			try 
			{
				bufferReader.close();
			} 
			catch (IOException e) 
			{
				System.out.println(e.getStackTrace());
			}

		}

		return sb.toString();

	}
	
}
