package com.TwoDimensionalArrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class SumOfDigAndBoundaries {

	public static void totalSum(int[][] mat) {
		// Your code goes here

		if (mat.length == 0) {
			System.out.println(0);
			return;
		}

		int totRows = mat.length;
		int totCol = mat[0].length;
		Map<String, Integer> finalValues = new HashMap<>();

		for (int i = 0; i < totRows; i++) {

			for (int j = 0; j < totCol; j++) {

				// Diagonals:
				if ((i == j) || (i + j == totRows - 1)) {
					finalValues.put(i + "" + j, mat[i][j]);
				}
				// Row Boundaries:
				if ((i == 0) || (i == totRows - 1)) {
					finalValues.put(i + "" + j, mat[i][j]);
				}

				// Column Boundaries:
				if ((i == 0) || (i == totCol - 1)) {
					// finalValues.add(mat[j][i]);
					finalValues.put(j + "" + i, mat[j][i]);
				}

			}
		}

		BinaryOperator<Integer> bi = (a, b) -> (a + b);
		// System.out.println(finalValues.stream().reduce(bi).get());

		Function<Entry<String, Integer>, Integer> fun = x -> x.getValue();
		System.out.println(finalValues.entrySet().stream().map(fun).reduce(bi).get());

	}

	public static void main(String[] args) {
		/*
		 * int A[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; totalSum(A);
		 * 
		 * int A1[][] = { { 1, 2, 3, 10 }, { 4, 5, 6, 11 }, { 7, 8, 9, 12 }, { 13, 14,
		 * 15, 16 } }; totalSum(A1);
		 */

		int A2[][] = { { 6, 9, 8, 5 }, { 9, 2, 4, 1 }, { 8, 3, 9, 3 }, { 8, 7, 8, 6 } };
		totalSum(A2);
	}
}
