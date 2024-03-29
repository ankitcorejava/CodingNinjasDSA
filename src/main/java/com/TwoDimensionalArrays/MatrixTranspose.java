package com.TwoDimensionalArrays;

public class MatrixTranspose {

	public static int[][] transpose(int m, int n, int[][] mat) {

		int[][] t_mat = new int[n][m];

		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {

				t_mat[col][row] = mat[row][col];
			}
		}

		return t_mat;
		// Write your code here
	}

	public static void main(String[] args) {

		int A1[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
		transpose(2, 3, A1);
	}
}
