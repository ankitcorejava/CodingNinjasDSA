package com.TwoDimensionalArrays;

/*
 * For a given two-dimensional integer array/list of size (N x M),
 *  print it in a spiral form. That is, you need to print in the order followed for every iteration:
	
	a. First row(left to right)
	b. Last column(top to bottom)
	c. Last row(right to left)
	d. First column(bottom to top)
 */
public class RowWiseSum2 {

	public static void rowWiseSum(int[][] mat) {

		if (mat.length < 1 || mat == null) {
			return;
		}

		int rowTotal = mat.length;
		int colTotal = mat[0].length;

		// Max Row
		for (int row = 0; row < rowTotal; row++) {

			int sum = 0;
			for (int col = 0; col < colTotal; col++) {
				sum = sum + mat[row][col];
			}

			System.out.print(sum + " ");

		}
	}

	public static void main(String[] args) {
		int A[][] = { { 6, 9, 8, 5 }, { 9, 2, 4, 1 }, { 8, 3, 9, 3 }, { 8, 7, 8, 6 } };
		rowWiseSum(A);

		System.out.println();

		int A1[][] = { { 2, 2 }, { 2, 2 } };
		rowWiseSum(A1);

		System.out.println();
		int A2[][] = { { 1, 4 }, { 1, 5 }, { 1, 7 } };
		rowWiseSum(A2);
	}

}
