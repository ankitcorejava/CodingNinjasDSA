package com.recursion_L1;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of length N and an integer x, you need to find all the indexes
 * where x is present in the input array. Save all the indexes in the output
 * array (in increasing order).
 * 
 * Do this recursively. Indexing in the array starts from 0.
 * 
 * Hint: Try making a helper function with the required arguments and call the
 * helper function from the allIndexes function. Detailed explanation (
 * Input/output format, Notes, Images ) Constraints : 1 <= N <= 10^3 Sample
 * Input : 5 9 8 10 8 8 8 Sample Output : 1 3 4
 */
public class FindAllIndexes {

	public static int[] allIndexes(int input[], int x) {

		List<Integer> finalList = helper_AllIndexes(input, x, input.length - 1);
		int icnt = 0;
		int[] finalOut = new int[finalList.size()];

		for (int lst : finalList) {
			finalOut[icnt] = lst;
			icnt++;
		}

		return finalOut;
	}

	public static List<Integer> helper_AllIndexes(int input[], int x, int idx) {

		if (idx < 0) {
			return new ArrayList<Integer>();
		}

		List<Integer> subList = helper_AllIndexes(input, x, idx - 1);
		if (input[idx] == x) {
			subList.add(idx);
		}
		return subList;
	}

	public static void main(String[] args) {
		int input[] = { 9, 8, 10, 8, 8 };
		List<Integer> finalList = helper_AllIndexes(input, 8, input.length - 1);
		System.out.println(finalList);

		int input1[] = { 9, 8, 10, 8, 8 };
		int input3[] = allIndexes(input1, 8);
		System.out.println(input3);
	}

}
