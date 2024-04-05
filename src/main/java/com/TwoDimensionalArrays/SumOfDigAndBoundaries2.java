package com.TwoDimensionalArrays;

public class SumOfDigAndBoundaries2 {

	public static int totalSum(int[][] matrix, int N) {
		int sum = 0;

		// Adding boundary elements
		for (int i = 0; i < N; i++) {
			sum += matrix[0][i]; // Top boundary
			sum += matrix[N - 1][i]; // Bottom boundary
			if (i != 0 && i != N - 1) {
				sum += matrix[i][0]; // Left boundary
				sum += matrix[i][N - 1]; // Right boundary
			}
		}

		// Subtracting common elements (corners are added twice, deduct once)
		sum -= matrix[0][0];
		sum -= matrix[0][N - 1];
		sum -= matrix[N - 1][0];
		sum -= matrix[N - 1][N - 1];

		// Adding diagonal elements
		for (int i = 0; i < N; i++) {
			sum += matrix[i][i]; // First diagonal
			sum += matrix[i][N - i - 1]; // Second diagonal
		}

		return sum;
	}

	public static void main(String[] args) {
		int A[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(totalSum(A, A.length));
		int A1[][] = { { 1, 2, 3, 10 }, { 4, 5, 6, 11 }, { 7, 8, 9, 12 }, { 13, 14, 15, 16 } };
		System.out.println(totalSum(A1, A1.length));

		int A2[][] = { { 6, 9, 8, 5 }, { 9, 2, 4, 1 }, { 8, 3, 9, 3 }, { 8, 7, 8, 6 } };
		System.out.println(totalSum(A2, A2.length));

	}

}