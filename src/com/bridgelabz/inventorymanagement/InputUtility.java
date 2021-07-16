package com.bridgelabz.inventorymanagement;

import java.util.Scanner;

public class InputUtility {
	private InputUtility() {
	}

	private static Scanner scanner = new Scanner(System.in);

	// To take Integer input
	public static int inputInteger() {
		return scanner.nextInt();
	}

	public static long inputLong() {
		return scanner.nextLong();
	}

	public static boolean checkNext() {
		return scanner.hasNext();
	}

	// To take Double input
	public static double inputDouble() {
		return scanner.nextDouble();
	}

	// To take Float input
	public static float inputFloat() {
		return scanner.nextFloat();
	}

	// To take String input
	public static String inputString() {
		return scanner.next();
	}

	// To take String input
	public static String inputStringLine() {
		return scanner.nextLine();
	}

}


