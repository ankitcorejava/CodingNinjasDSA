package com.TwoDimensionalArrays;

/*
 * For a given two-dimensional integer array/list of size 
 * (N x M), print it in a spiral form. That is, 
 * you need to print in the order followed for every iteration:

a. First row(left to right)
b. Last column(top to bottom)
c. Last row(right to left)
d. First column(bottom to top)
 * 
 */

public class SpiralPrint2 {

	public static void spiralPrint(int matrix[][]) {
		// Your code goes here

		if (matrix.length < 1 || matrix == null) {
			return;
		}
		int iRow_min = 0;
		int iCol_min = 0;
		int iRow_max = matrix.length;
		int iCol_max = matrix[0].length;
		int totalElement = iRow_max * iCol_max;
		int iCnt = 0;

		while (iCnt < totalElement) {

			/* ::::::::::::Top Wall:::::::::: */
			if (iCnt < totalElement) {
				for (int j = iCol_min, i = iRow_min; j < iCol_max; j++) {
					System.out.print(matrix[i][j] + " ");
					iCnt++;
				}

				iRow_min++;
			}

			/* ::::::::::::Right Wall:::::::::: */
			if (iCnt < totalElement) {
				for (int i = iRow_min, j = iCol_max - 1; i < iRow_max; i++) {
					System.out.print(matrix[i][j] + " ");
					iCnt++;
				}
				iCol_max--;
			}

			if (iCnt < totalElement) {
				/* ::::::::::::Bottom Wall:::::::::: */
				for (int j = iCol_max - 1, i = iRow_max - 1; j >= iCol_min; j--) {
					System.out.print(matrix[i][j] + " ");
					iCnt++;
				}
				iRow_max--;
			}

			/* ::::::::::::Left Wall:::::::::: */
			if (iCnt < totalElement) {
				for (int i = iRow_max - 1, j = iCol_min; i >= iRow_min; i--) {
					System.out.print(matrix[i][j] + " ");
					iCnt++;
				}

				iCol_min++;
			}

		}
	}

	public static void main(String[] args) {
		/*
		 * int A[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; spiralPrint(A);
		 */

		int A2[][] = { { 10, 20, 30 }};
		spiralPrint(A2);
	}

}
