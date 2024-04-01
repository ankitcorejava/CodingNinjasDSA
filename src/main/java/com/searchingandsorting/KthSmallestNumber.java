package com.searchingandsorting;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * You are given an integer array 'arr' of size 'N'.
 * 
 * You must sort this array using 'Bubble Sort'. Note: Change in the input array
 * itself. You don't need to return or print the elements. Example: Input: ‘N’ =
 * 7 'arr' = [2, 13, 4, 1, 3, 6, 28]
 * 
 * Output: [1 2 3 4 6 13 28] * Explanation: After applying bubble sort on the
 * input array, the output is [1 2 3 4 6 13 28].
 */
public class KthSmallestNumber {

	public static int kthSmallest(int[] arr, int n, int k) {
		// Your code goes here

		arr = bubbleSort(arr, n);

		return arr[k - 1];
	}

	public static int[] bubbleSort(int[] arr, int n) {

		for (int i = 1; i <= arr.length - 1; i++) {

			for (int j = 0; j < (arr.length) - i; j++) {

				if (arr[j] > arr[j + 1]) {
					arr = swap(arr, j, (j + 1));
				}
			}
		}

		// System.out.println(arr);
		Arrays.stream(arr).boxed().forEach(x -> System.out.println(x));

		return arr;
	}

	private static int[] swap(int arr[], int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}

	public static void main(String[] args) {

		int input[] = { 3, 2, 11, 5, 1 };
		//bubbleSort(input, input.length);
		System.out.println(kthSmallest(input, input.length, 2));

	}

}
