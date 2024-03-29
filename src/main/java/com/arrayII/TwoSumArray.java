package com.arrayII;

import java.util.Arrays;

public class TwoSumArray {

	// arr1 =6 2 4
	// arr2 =7 5 6
	public static void sumOfTwoArrays(int arr1[], int arr2[], int output[]) {
		
		int carry = 0;
		for (int i = 0; i < output.length; i++) {

			int a = 0;
			int b = 0;
			int sum = 0;
			int mod = 0;

			if (i < arr1.length) {
				a = arr1[(arr1.length - 1) - i];
			}
			if (i < arr2.length) {
				b = arr2[(arr2.length - 1) - i];
			}

			sum = a + b + carry;
			mod = (sum % 10);

			carry = sum >= 10 ? 1 : 0;

			output[(output.length - 1) - i] = mod;

		}

		System.out.println(":::::::::::::::Final output:::::::::::::::");
		Arrays.stream(output).boxed().forEach(z -> System.out.print(z));
	}

	public static void main(String[] args) {

		int[] a = { 6, 2};
		int[] b = { 7, 5, 6 };
		int[] output = new int[4];
		TwoSumArray.sumOfTwoArrays(a, b, output);

	}

}
