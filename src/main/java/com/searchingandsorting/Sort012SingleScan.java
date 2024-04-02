package com.searchingandsorting;

/**
 * You are given an integer array/list(ARR) of size N. It contains only 0s, 1s
 * and 2s. Write a solution to sort this array/list in a 'single scan'.
 * 
 * 'Single Scan' refers to iterating over the array/list just once or to put it
 * in other words, you will be visiting each element in the array/list just
 * once.
 * 
 * Note: You need to change in the given array/list itself. Hence, no need to
 * return or print anything. Detailed explanation ( Input/output format, Notes,
 * Images ) Constraints : 1 <= t <= 10^2 0 <= N <= 10^1
 * 
 * Time Limit: 1 sec Sample Input 1: 1 7 0 1 2 0 2 0 1 Sample Output 1: 0 0 0 1
 * 1 2 2 Sample Input 2: 2 5 2 2 0 1 1 7 0 1 2 0 1 2 0 Sample Output 2: 0 1 1 2
 * 2 0 0 0 1 1 2 2
 */
public class Sort012SingleScan {

	public static void sort012(int[] arr, int n) {

		int low = 0;
		int mid = 0;
		int high = n - 1;

		while (mid <= high) {

			// mid ==0;
			if (arr[mid] == 0) {
				arr = swap(arr, low, mid);
				low++;
				mid++;
			}
			// mid ==1;
			else if (arr[mid] == 1) {
				mid++;
			}
			else if (arr[mid] == 2) {
				arr = swap(arr, high, mid);
				high--;
			}

		}
		System.out.println(arr);
	}

	private static int[] swap(int[] arr, int iI, int iII) {

		int temp = arr[iI];
		arr[iI] = arr[iII];
		arr[iII] = temp;

		return arr;

	}

	public static void main(String[] args) {
		int arr2[] = { 0, 1, 2, 0, 2, 0, 1 };
		sort012(arr2, arr2.length);

	}

}
