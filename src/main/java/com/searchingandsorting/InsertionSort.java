package com.searchingandsorting;

/**
 * You are given an integer array 'arr' of size 'N'. You must sort this array
 * using 'Insertion Sort' recursively. Note: Change in the input array itself.
 * You don't need to return or print the elements. Example: Input: ‘N’ = 7 'arr'
 * = [2, 13, 4, 1, 3, 6, 28]
 * 
 * Output: [1 2 3 4 6 13 28]
 */
public class InsertionSort {

	public static void insertionSort(int[] arr, int size) {

		for (int i = 0; i < arr.length-1; i++) {
			int j = i + 1;
			if (arr[j] < arr[i]) {
				while ((j > 0) && (arr[j] < arr[j - 1])) {
					arr = swap(arr, j, (j - 1));
					j--;
				}
			}

		}
		//System.out.println(arr);

	}

	private static int[] swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
		return arr;

	}
	
	public static void main(String[] args) {
		int input[] = {2, 13, 4, 1, 3, 6, 28};
		insertionSort(input,input.length);
	}

}
