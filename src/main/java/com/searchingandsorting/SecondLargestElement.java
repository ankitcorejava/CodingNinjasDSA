package com.searchingandsorting;

/**
 * You have been given a random integer array/list(ARR) of size N. You are
 * required to find and return the second largest element present in the
 * array/list.
 * 
 * Detailed explanation ( Input/output format, Notes, Images ) Constraints : 0
 * <= N <= 10^2 1<=arr[i]<=10^3
 * 
 * Time Limit: 1 sec Sample Input 1: 5 4 3 10 9 2 Sample Output 1: 9
 */
public class SecondLargestElement {

	public static int secondLargestElement(int[] arr, int n) {

		if (arr.length == 0) {
			return -1;
		}

		int IstMax = Integer.MIN_VALUE;
		int IIndMax = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

			if (IstMax < arr[i]) {
				IIndMax = IstMax;
				IstMax = arr[i];
			}
			if ((IIndMax < arr[i]) && (arr[i] < IstMax)) {
				IIndMax = arr[i];
			}

		}

		return IIndMax;

	}

	public static void main(String[] args) {

		int num[] = { 13, 6, 31,14, 29, 44, 103,3};
		System.out.println(secondLargestElement(num, num.length));
	}

}
