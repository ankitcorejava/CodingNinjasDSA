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
public class SubsetsOfArraysString {

	public static void helper_subsets(List<Integer> inputList, String ansSoFar, List<String> andList) {

		// Base Case:
		if (inputList.size() == 0) {
			// System.out.println(ansSoFar);
			andList.add(ansSoFar);
			return;
		}

		int Ist = inputList.get(0);
		Predicate<Integer> pre = x -> x != Ist;
		List<Integer> subList = inputList.stream().filter(pre).collect(Collectors.toList());

		helper_subsets(subList, ansSoFar + "," + Ist, andList);
		helper_subsets(subList, ansSoFar, andList);

	}

	public static void main(String[] args) {

		int input[] = { 15, 20, 12 };
		List<String> list = new ArrayList<>();
		helper_subsets(Arrays.stream(input).boxed().collect(Collectors.toList()), "", list);
		list.sort(Collections.reverseOrder().reversed());
		System.out.println(list);

	}

}
