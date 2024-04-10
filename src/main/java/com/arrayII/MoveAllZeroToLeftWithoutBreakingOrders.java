package com.arrayII;

public class MoveAllZeroToLeftWithoutBreakingOrders {

	public static void moveAllZeroToLeftWithoutBreakingOrders(int[] input) {

		int nz = 0;
		int z = 0;

		while (nz < input.length - 1) {
			
			System.out.println("input[nz]: "+ input[nz]+ " input[z]: " + input[z]);

			if (input[nz] != 0) {

				nz++;
			} else if (input[z] == 0 && input[nz] == 0) {
				nz++;
				continue;
			}

			else {				

				for (int i = nz - 1; i <= nz; i--) {
					swap(input, i, (i - 1));
				}
				nz++;
				z++;
			}

		}

	}

	private static int[] swap(int[] input, int nz, int i) {
		
		System.out.println("Swaping : " + input[nz]+ " , "+ input[i] );
		int temp = input[nz];
		input[nz] = input[i];
		input[i] = temp;

		return input;

	}

	public static void main(String[] args) {
		int[] arr = { 0, 2, 0, 3, 4, 0, 5 };
		moveAllZeroToLeftWithoutBreakingOrders(arr);
	}

}
