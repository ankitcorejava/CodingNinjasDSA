package com.TwoDimensionalArrays;

import java.util.Arrays;

public class PrintRowWise {

	public static void setZeros(int matrix[][]) {
		// Write your code here.
		int rows = matrix.length;
		int cols = matrix[0].length;

		final int[][] input = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				input[i][j] = matrix[i][j];
			}
		}

		for (int row = 0; row < rows; row++) {

			for (int col = 0; col < cols; col++) {
				System.out.print(input[row][col]);

				if (input[row][col] == 0) {
					// Making all rows Zero by making Row constant and increasing col 0 to max;
					for (int i = 0; i < cols; i++) {
						matrix[row][i] = 0;
					}
					// Making all the columns Zero by making Col Constant and increasing row o to
					// max;
					for (int j = 0; j < rows; j++) {
						matrix[j][col] = 0;
					}
				}
			}
		}

		System.out.println(matrix);
	}

	public static void main(String[] args) {
		int A[][] = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } };
		setZeros(A);
		System.out.println(A);
	}

}
