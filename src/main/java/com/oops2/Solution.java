package com.oops2;

import java.util.Scanner;

public class Solution {

	// Main driver method
	public static void main(String[] args) {

		// Take input using Scanner and print the output .
		Scanner s = new Scanner(System.in);
		int num1 = s.nextInt();
		int num2 = s.nextInt();
		int num3 = s.nextInt();
		/*
		 * int[] input = new int[num]; for (int i = 0; i < num; i++) { input[i] =
		 * s.nextInt(); }
		 */

		Helper helper = new Helper();
		System.out.println(helper.multiplication(num1, num2));
		System.out.println(helper.multiplication(num1, num2, num3));

	}
}
