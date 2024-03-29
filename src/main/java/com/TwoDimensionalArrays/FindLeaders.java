package com.TwoDimensionalArrays;

/*
 * Given an integer array A of size n. Find and print all the leaders present in the input array. An array element A[i] is called Leader, if all the elements following it (i.e. present at its right) are less than or equal to A[i].

Print all the leader elements separated by space and in the reverse order. That means whichever leader comes at last should be printed first.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= n <= 10^6

Sample Input 1 :
6
3 12 34 2 0 -1
Sample Output 1 :
-1 0 2 34
Sample Input 2 :
5
13 17 5 4 6
Sample Output 2 :
6 17
 * 
 * 
 */
public class FindLeaders {

	public static void leaders(int[] input) {
		/*
		 * Your class should be named Solution Don't write main(). Don't read input, it
		 * is passed as function argument. Print output and don't return it. Taking
		 * input is handled automatically.
		 */
		boolean iState = false;
		if (input.length > 0) {
			for (int i = (input.length - 1); i >= 0; i--) {

				if (i == (input.length - 1)) {
					System.out.print(input[i] + " ");
				} else {
					iState = false;
					for (int j = i; j < input.length; j++) {
						if (input[i] >= input[j]) {
							iState = true;
						}
						else {
							iState = false;
							break;
						}
					}
					if (iState == true) {
						System.out.print(input[i] + " ");
					}

				}
			}
		} else {
			return;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int[] input = { 3, 12, 34, 2, 0, -1 };
		leaders(input);

		int[] input2 = { 13, 17, 5, 4, 6 };
		leaders(input2);
	}

}
