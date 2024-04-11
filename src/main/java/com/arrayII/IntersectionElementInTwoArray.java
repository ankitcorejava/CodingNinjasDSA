package com.arrayII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The intersection elements printed would be in ascending order.
 * 
 * 
 * Detailed explanation ( Input/output format, Notes, Images ) Constraints : 1
 * <= t <= 10^2 0 <= N <= 10^4 0 <= M <= 10^4
 * 
 * Time Limit: 1 sec Sample Input 1 : 2 6 2 6 8 5 4 3 4 2 3 4 7 2 10 10 1 10
 */
public class IntersectionElementInTwoArray {

	public static void intersection(int[] arr1, int[] arr2) {
		// Your code goes here

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		//Arrays.stream(arr1).boxed().forEach(x -> System.out.print(x));

		//System.out.println();

		//Arrays.stream(arr2).boxed().forEach(x -> System.out.print(x));

		int arr1Idx = 0;
		int arr2Idx = 0;
		List<Integer> list = new ArrayList<>();

		while ((arr1Idx < arr1.length) && (arr2Idx < arr2.length)) {

			if (arr1[arr1Idx] > arr2[arr2Idx]) {

				arr2Idx++;
			} else if (arr1[arr1Idx] < arr2[arr2Idx]) {

				arr1Idx++;
			} else {
				// return arr1[arr1Idx];
				list.add(arr1[arr1Idx]);
				arr2Idx++;
				arr1Idx++;
			}

		}

		list.forEach(x-> System.out.print(x+" "));
		//System.out.println(list);

	}

	public static void main(String[] args) {

		int[] arr1 = { 2, 6, 8, 5, 4, 3 };

		int[] arr2 = { 2, 3, 4, 7 };

		intersection(arr1, arr2);
	}
}
