package com.recursion_L2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * Given an array A of size n and an integer K, return all subsets of A which
 * sum to K.
 * 
 * Subsets are of length varying from 0 to n, that contain elements of the
 * array. But the order of elements should remain same as in the input array.
 * 
 * 
 * Note : The order of subsets are not important.
 * 
 * 
 * Detailed explanation ( Input/output format, Notes, Images ) Constraints : 1
 * <= n <= 20
 * 
 * Sample Input : 9 5 12 3 17 1 18 15 3 17 6 Sample Output : 3 3 5 1
 */
public class ReturnSubsetsSumK {

	public static int[][] subsetsSumK(int input[], int k) {
		List<List<Integer>> result = new ArrayList<>();
		generateSubsets(input, 0, new ArrayList<>(), result);
		return convertToArray(result, k);
	}

	private static void generateSubsets(int[] nums, int index, List<Integer> currentSubset,
			List<List<Integer>> result) {
		result.add(new ArrayList<>(currentSubset)); // Add currentSubset to result
		for (int i = index; i < nums.length; i++) {
			currentSubset.add(nums[i]); // Include current element in the subset
			generateSubsets(nums, i + 1, currentSubset, result); // Recur for next index
			currentSubset.remove(currentSubset.size() - 1); // Backtrack (remove last element)
		}
	}

	private static int[][] convertToArray(List<List<Integer>> result, int k) {

		List<List<Integer>> ansLists = new ArrayList<List<Integer>>();

		for (int i = 0; i < result.size(); i++) {

			List<Integer> subsetList = result.get(i);
			if (subsetList.size() > 0) {
				BinaryOperator<Integer> bit = (a, b) -> (a + b);
				int sum = subsetList.stream().collect(Collectors.reducing(bit)).get();
				if (sum == k) {
					ansLists.add(subsetList);
				}

			}

		}

		//System.out.println(ansLists);

		int[][] subsets = new int[ansLists.size()][];
		for (int i = 0; i < ansLists.size(); i++) {
			List<Integer> subsetList = ansLists.get(i);
			subsets[i] = new int[subsetList.size()];
			for (int j = 0; j < subsetList.size(); j++) {
				subsets[i][j] = subsetList.get(j);
			}
		}
		return subsets;
	}

	public static void main(String[] args) {

		int input[] = { 5, 12, 3, 17, 1, 18, 15, 3, 17 };
		System.out.println(subsetsSumK(input, 6));
	}

}
