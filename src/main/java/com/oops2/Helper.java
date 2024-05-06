package com.oops2;

/**
 * You are tasked with creating a Java program that performs multiplication
 * operations on integers. The program should utilize a helper class called
 * "Helper" containing two overloaded methods for multiplication. The main
 * class, named "Main," will take user input for one or more integers and call
 * the appropriate method from the "Helper" class to calculate the product.
 * 
 * simple input : 5 3 7 Sample output : 15 105
 */
public class Helper {

	// Method 1
	// Multiplication of 2 numbers
	public int multiplication(int a, int b) {
		return (a * b);
	}

	// Method 2
	// // Multiplication of 3 numbers
	public int multiplication(int a, int b, int c) {
		return (a * b * c);
	}
}
