package com.TwoDimensionalArrays;

public class SquareMatrix {

	public static String sqrMat(int[][] mat, int n, int m, int diag[]) {
		// Write your code here.
		if (n != m) {
			return "NO";
		}

		for (int i = 0; i < n; i++) {
			diag[i] = mat[i][i];
		}

		return "YES";

	}

	public static void main(String[] args) {

		int A[][] = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } };
		sqrMat(A, 3, 3, new int[3]);
	}

}
