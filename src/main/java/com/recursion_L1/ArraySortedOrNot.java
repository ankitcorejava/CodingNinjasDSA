package com.recursion_L1;

public class ArraySortedOrNot {

	public static boolean arraySortedOrNot(int[] A, int N) {

		try {

			// Base Case:::
			if (N == 0) {
				return true;
			}

			boolean status = arraySortedOrNot(A, (N - 1));

			if (N < A.length - 1) {

				//System.out.println("A[N + 1] :" + (A[N + 1]) + " > A[N]: " + A[N] + " : " + (A[N + 1] > A[N]));
				if ((A[N + 1] >= A[N]) && (status)) {
					return true;
				} else {
					return false;
				}
			}

			return status;
		} catch (Exception e) {
			return false;
		}

	}

	public static void main(String[] args) {

		int[] A0 = { 0 };
		System.out.println(arraySortedOrNot(A0, A0.length));

		int[] A = { 1, 3, 6, 10, 0 };
		System.out.println(arraySortedOrNot(A, A.length));

		int[] A1 = { 0, 3, 3, 3, 3, 3, 4, 5, 9, 9, 12, 12, 13, 28, 29, 32, 40, 40, 40, 42, 42, 43, 45, 45, 53, 57, 60,
				65, 66, 70, 72, 72, 80, 82, 87, 94, 98, 103, 107, 109, 111, 111, 119, 120, 124, 131, 132, 132, 140, 140,
				141, 143, 144, 146, 147, 151, 157 };
		System.out.println(arraySortedOrNot(A1, A1.length));
	}

}
