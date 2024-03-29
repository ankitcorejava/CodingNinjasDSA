package com.recursion_L1;

/**
 * Problem statement Write a recursive function that returns the sum of the
 * digits of a given integer.
 * 
 * Detailed explanation ( Input/output format, Notes, Images ) Constraints : 0
 * <= N <= 10^9 Sample Input 1 : 12345 Sample Output 1 : 15 Sample Input 2 : 9
 * Sample Output 2 : 9
 */
public class SumOfDigits {

	public static int sumOfDigits(int input) {

		if (input == 0) {
			return 0;
		}

		int sub = sumOfDigits(input / 10);

		int finalSum = sub + (input % 10);

		return (finalSum);
	}

	public static void main(String[] args) {
		System.out.println(sumOfDigits(1231));
	}
}
