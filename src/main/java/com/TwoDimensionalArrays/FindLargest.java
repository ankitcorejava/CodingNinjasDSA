package com.TwoDimensionalArrays;

public class FindLargest {

	public static void findLargest(int mat[][]) {
		// Your code goes here

		if (mat.length < 1) {
			System.out.print("row" + " " + 0 + " " + Integer.MIN_VALUE);
			return;
		}

		int finalMax = Integer.MIN_VALUE;
		int finalIdx = 0;

		int rowMax = Integer.MIN_VALUE;
		int colMax = Integer.MIN_VALUE;

		int rowTotal = mat.length;
		int colTotal = mat[0].length;

		String rowCol = "";
		int rowIndex = 0;
		int colIndex = 0;

		// Max Row
		for (int row = 0; row < rowTotal; row++) {

			int sum = 0;
			for (int col = 0; col < colTotal; col++) {
				sum = sum + mat[row][col];
			}

			if (rowMax < sum) {
				rowMax = sum;
				rowIndex = row;

			}
		}

		// Max Column
		for (int col = 0; col < colTotal; col++) {

			int sum = 0;
			for (int row = 0; row < rowTotal; row++) {
				sum = sum + mat[row][col];
			}

			if (colMax < sum) {
				colMax = sum;
				colIndex = col;
			}

		}

		if (rowMax >= colMax) {
			rowCol = "row";
			finalMax = rowMax;
			finalIdx = rowIndex;

		} else {
			rowCol = "column";
			finalMax = colMax;
			finalIdx = colIndex;
		}

		System.out.print(rowCol + " " + finalIdx + " " + finalMax);
	}

	public static void main(String[] args) {
		int A[][] = { { 6, 9, 8, 5 }, { 9, 2, 4, 1 }, { 8, 3, 9, 3 }, { 8, 7, 8, 6 } };
		findLargest(A);
		
		System.out.println();
		
		int A1[][] = { {2,2},{2,2}};
		findLargest(A1);
		
		System.out.println();
		int A2[][] = { {1},{1}};
		findLargest(A2);
	}

}
