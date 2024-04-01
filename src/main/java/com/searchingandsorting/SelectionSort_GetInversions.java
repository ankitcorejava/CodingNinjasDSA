package com.searchingandsorting;

import java.util.Arrays;

/**
 * You have a list of numbers that are not in order. You want to find the sum of
 * the differences between the indices of pairs of numbers that are in the wrong
 * order. A pair of numbers is considered to be in the wrong order if the
 * smaller number comes after the larger number in the list.
 * 
 * Example: Input: ‘N’ = 5 ‘A’ = [3, 2, 11, 5, 1]
 * 
 * Output: 6
 * 
 * Sample Input 1: 5 3 2 11 5 1 Sample Output 1: 6 Explanation When we apply
 * selection sort, first swap will happen between array[0] to array[4],
 * inversion will be (index of arrar[4]-index of array[0]) = 4-0=4 and the array
 * after this will be [1, 2, 11, 5, 3], still the array is not sorted. So we
 * will apply selection sort again, the swap will now take place between
 * array[2] and array[4], inversion will be 4+(index of arrar[4]-index of
 * array[2])=4+(4-2)=4+2=6.So the final sorted array now will be [1,2,3,5,11]
 */
public class SelectionSort_GetInversions {

	public static int getInversions(int[] arr, int n) {
		int min = 0;
		int inversion = 0;
		for (int i = 0; i < arr.length - 1; i++) {

			min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}

			}
			System.out.println(i + " , " + min + " = " + (min - i));
			inversion = inversion + (min - i);
			swap(arr, i, min);

		}

		// Arrays.stream(arr).boxed().forEach(x -> System.out.println(x));
		return inversion;

	}

	private static int[] swap(int[] arr, int i, int min) {
		int temp = arr[i];
		arr[i] = arr[min];
		arr[min] = temp;
		return arr;
	}

	public static void main(String[] args) {

		int[] input = { 3, 2, 11, 5, 1 };
		System.out.println(getInversions(input, input.length));

		System.out.println();

		int[] input1 = { 17, 5, 14, 16, 11, 18, 10 };
		System.out.println(getInversions(input1, input1.length));
	}

}
