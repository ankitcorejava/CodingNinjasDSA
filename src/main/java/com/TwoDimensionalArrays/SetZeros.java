package com.TwoDimensionalArrays;

public class SetZeros {

	public static int[] printRowWise(int[][] a) {
		// Write your code here.
		int rows = a.length;
		int cols = a[0].length;
		int outPut[] = new int[rows * cols];
		int icnt = 0;
		for (int row = 0; row < rows; row++) {

			for (int col = 0; col < cols; col++) {
				System.out.print(a[row][col]);
				outPut[icnt] = a[row][col];
				icnt++;
			}
		}
		return outPut;
	}

	public static void main(String[] args) {
		int A[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
		int out[] = printRowWise(A);
		System.out.println(out);
	}

}
