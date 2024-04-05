package com.recursion_L2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Given an integer array (of length n), find and return all the subsets of
 * input array.
 * 
 * NOTE- Subsets are of length varying from 0 to n, that contain elements of the
 * array. But the order of elements should remain same as in the input array.
 * 
 * Note : The order of subsets are not important.
 * 
 * 
 * Detailed explanation ( Input/output format, Notes, Images ) Sample Input: 3
 * 15 20 12 Sample Output: [] (this just represents an empty array, don't worry
 * about the square brackets) 12 20 20 12 15 15 12 15 20 15 20 12
 * 
 */
public class SubsetsOfArraysWithList {

	public static int[][] subsets(int input[]) {

		List<List<Integer>> andList = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();

		List<Integer> input_list = Arrays.stream(input).boxed().collect(Collectors.toList());

		helper_subsets(input_list, list, andList);

		int[][] subsets = new int[andList.size()][];
        for (int i = 0; i < andList.size(); i++) {
            List<Integer> subsetList = andList.get(i);
            subsets[i] = new int[subsetList.size()];
            for (int j = 0; j < subsetList.size(); j++) {
                subsets[i][j] = subsetList.get(j);
            }
        }
        
       // Arrays.stream(subsets).sorted(Collections.reverseOrder().reversed());
        return subsets;

	}

	public static void helper_subsets(List<Integer> inputList, List<Integer> ansSoFar, List<List<Integer>> andList) {

		// Base Case:
		if (inputList.size() == 0) {
			// System.out.println(ansSoFar);
			andList.add(new ArrayList<>(ansSoFar));
			// ansSoFar = new ArrayList<>();
			return;
		}

		int Ist = inputList.get(0);
		Predicate<Integer> pre = x -> x != Ist;
		List<Integer> subList = inputList.stream().filter(pre).collect(Collectors.toList());

		helper_subsets(subList, ansSoFar, andList);
		ansSoFar.add(Ist);
		helper_subsets(subList, new ArrayList<>(ansSoFar), andList);
		ansSoFar.remove(ansSoFar.size() - 1);

	}

	public static void main(String[] args) {

		int input[] = { 15, 15, 14, 7, 2, 8, 3, 2 };

		List<List<Integer>> andList = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();

		List<Integer> input_list = Arrays.stream(input).boxed().collect(Collectors.toList());

		helper_subsets(input_list, list, andList);

		System.out.println(subsets(input));

		// andList.stream().forEach(x -> System.out.println(x));
	}

}
