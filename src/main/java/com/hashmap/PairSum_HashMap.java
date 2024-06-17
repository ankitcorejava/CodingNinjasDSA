package com.hashmap;

/**
 * Given a random integer array A of size N. Find and print the count of pair of
 * elements in the array which sum up to 0.
 */
public class PairSum_HashMap {

	public static void main(String[] args) {
		int[] input = { 2, 1, -2, 2, 3 };
		int[] input1 = { 0, 0, 0, 0, 0 };
		int size = 5;

		System.out.println(PairSum(input, size));
	}

	public static int PairSum(int[] input, int size) {

		int icnt = 0;

		for (int i = 0; i < input.length; i++) {

			for (int j = i + 1; j < input.length; j++) {
				if (input[i] + input[j] == 0) {
					icnt++;
				}
			}

		}
		return icnt;
	}

}
