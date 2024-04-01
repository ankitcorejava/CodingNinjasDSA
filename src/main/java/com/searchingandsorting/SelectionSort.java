package com.searchingandsorting;

import java.util.Arrays;

/**
 * Sort the given unsorted array 'arr' of size 'N' in non-decreasing order using
 * the selection sort algorithm.
 * 
 * Note: Change in the input array/list itself.
 * 
 * Example: Input: N = 5 arr = {8, 6, 2, 5, 1}
 * 
 * Output: 1 2 5 6 8
 */
public class SelectionSort {

	public static void selectionSort(int[] arr) {
		int min = 0;
		for (int i = 0; i < arr.length - 1; i++) {

			min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}

			}
			swap(arr, i, min);
		}

		Arrays.stream(arr).boxed().forEach(x -> System.out.println(x));

	}

	private static int[] swap(int[] arr, int i, int min) {
		int temp = arr[i];
		arr[i] = arr[min];
		arr[min] = temp;
		return arr;
	}

	public static void main(String[] args) {

		int[] input = { 8, 6, 2, 5, 1 };
		selectionSort(input);
		
		System.out.println();
		
		int[] input1 = {2 ,13 ,4, 1 ,3 ,6 };
		selectionSort(input1);
	}

}
