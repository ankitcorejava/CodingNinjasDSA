package com.TwoDimensionalArrays;

public class SpiralPrint {

	public static void spiralPrint(int matrix[][]) {
		// Your code goes here
		int iRow_min = 0;
		int iCol_min = 0;
		int iRow_max = matrix.length-1;
		int iCol_max = matrix[0].length-1;
		int totalElement = iRow_max * iCol_max;
		int iCnt = 0;

		while (iCnt < totalElement) {

			/* ::::::::::::Left Wall:::::::::: */
			for (int i = iRow_min, j = iCol_min; i < iRow_max; i++) {
				System.out.print(matrix[i][j]+" ");
			}
			iCnt++;
			iCol_min++;

			/* ::::::::::::Bottom Wall:::::::::: */
			for (int j = iCol_min, i = iRow_max; j < iCol_max; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			iCnt++;
			iRow_max--;

			/* ::::::::::::Right Wall:::::::::: */
			for (int i = iRow_max, j = iCol_max; j >= iCol_min; j--) {
				System.out.print(matrix[i][j]+" ");
			}
			iCnt++;
			iCol_max--;

			/* ::::::::::::Top Wall:::::::::: */
			for (int j = iCol_max, i = iRow_min; j >= iCol_min; j--) {
				System.out.print(matrix[i][j]+" ");
			}
			iCnt++;
			iRow_min++;
		}
	}

	public static void main(String[] args) {
		int A[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		spiralPrint(A);
	}

}
