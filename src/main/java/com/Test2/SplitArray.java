package com.Test2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array A of size N, check if the input array can be divided
 * in two groups G1 and G2 with following properties-
 * 
 * - Sum of both group elements are equal - Group 1: All elements in the input,
 * which are divisible by 5 - Group 2: All elements in the input, which are
 * divisible by 3 (but not divisible by 5). - Elements which are neither
 * divisible by 5 nor by 3, can be put in either group G1 or G2 to satisfy the
 * equal sum property. Group 1 and Group 2 are allowed to be unordered and all
 * the elements in the Array A must belong to only one of the groups.
 * 
 * 
 * 
 * Return true, if array can be split according to the above rules, else return
 * false.
 * 
 * Note: You will get marks only if all the test cases are passed.
 */
public class SplitArray {

	public static boolean splitArray(int input[]) {

		List<Integer> listG1 = new ArrayList<>();

		List<Integer> listG2 = new ArrayList<>();

		List<Integer> listG3 = new ArrayList<>();

		for (int i = 0; i < input.length; i++) {
			/** Group 1: All elements in the input, which are divisible by 5 **/
			if ((input[i] % 5) == 0) {

				listG1.add(input[i]);
			}

			/**
			 * Group 2: All elements in the input, which are divisible by 3 (but not
			 * divisible by 5).
			 **/
			else if (((input[i] % 3) == 0) && ((input[i] % 5) != 0)) {

				listG2.add(input[i]);
			} else {
				listG3.add(input[i]);
			}

		}

		return false;

	}

}
