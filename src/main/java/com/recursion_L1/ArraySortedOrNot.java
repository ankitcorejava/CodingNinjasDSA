package com.recursion_L1;

public class ArraySortedOrNot {

	public static boolean arraySortedOrNot(int[] A, int N) {

		if (A == null || A.length < 1) {
			return false;
		}

		// Base Case:::
		if (N == 0) {
			return true;
		}

		if (N < A.length - 1) {
			if ((A[N + 1] < A[N])) {
				return false;
			}
		}

		return arraySortedOrNot(A, (N - 1));

	}

	public static void main(String[] args) {

		int[] A0 = { 0 };
		System.out.println(arraySortedOrNot(A0, A0.length));

		System.out.println(arraySortedOrNot(null, 0));

		int[] A = { 1, 3, 6, 10, 0, 0, 0 };
		System.out.println(arraySortedOrNot(A, A.length));

		int[] A1 = { 0, 3, 3, 3, 3, 3, 4, 5, 9, 9, 12, 12, 13, 28, 29, 32, 40, 40, 40, 42, 42, 43, 45, 45, 53, 57, 60,
				65, 66, 70, 72, 72, 80, 82, 87, 94, 98, 103, 107, 109, 111, 111, 119, 120, 124, 131, 132, 132, 140, 140,
				141, 143, 144, 146, 147, 151, 157, 158, 159, 200, 300, 350, 360, 370, 1 };
		System.out.println(arraySortedOrNot(A1, A1.length));
	}

}
