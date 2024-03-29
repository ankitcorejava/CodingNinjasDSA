package com.TwoDimensionalArrays;

public class RowWiseSum {

	public static void rowWiseSum(int[][] mat) {

		if (mat.length < 1||mat == null) {
			return;
		}
		
		if(mat.length >0) {

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
		}else {
			return;
		}
	}

	public static void main(String[] args) {
		int A[][] = { { 6, 9, 8, 5 }, { 9, 2, 4, 1 }, { 8, 3, 9, 3 }, { 8, 7, 8, 6 } };
		rowWiseSum(A);

		System.out.println();

		int A1[][] = { { 2, 2 }, { 2, 2 } };
		rowWiseSum(A1);

		System.out.println();
		int A2[][] = { { -1,4 }, { 1,5},{ -1,-7}  };
		rowWiseSum(A2);
	}

}
