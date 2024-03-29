package com.arrayII;

import java.util.Arrays;
import java.util.Scanner;

/*
Problem statement
	There is an array ‘A’ of size ‘N’.	
	You are also given an integer ‘X’ and direction ‘DIR’. 
	You must rotate the array in the direction of ‘DIR’ by ‘X’ positions.	
	You must return the rotated array. 
 */
public class RotateArray {

	public static int[] rotateArray(int[] a, int x, String dir) {

		// Rotation mod to minimize the rotation:

		x = x % (a.length);

		if ("LEFT".equalsIgnoreCase(dir)) {
			// Split the array in two parts:
			// part1 = 0 to x -1;
			int leftLen = x - 1;
			int i = 0;
			while (i < leftLen) {
				a = reverse(a, i, (leftLen - i));
				i++;
			}
			/*
			 * System.out.println("Post left"); System.out.println();
			 * Arrays.stream(a).boxed().forEach(y -> System.out.print(y+","));
			 * System.out.println(); System.out.println("Post Right"); System.out.println();
			 */

			// part2 = x to len -1;
			int rightLen = a.length - 1;
			int j = x;
			int k = 0;
			while (j < rightLen - 1) {
				// System.out.print("start: " + j + ", end: " + (rightLen - k));
				a = reverse(a, j, (rightLen - k));
				/*
				 * System.out.println(); Arrays.stream(a).boxed().forEach(y ->
				 * System.out.print(y+",")); System.out.println();
				 */
				j++;
				k++;
			}

		}

		if ("RIGHT".equalsIgnoreCase(dir)) {
			// Split the array in two parts:
			// part1 = 0 to x -1;
			int leftLen = (a.length - 1 - x);
			int i = 0;
			while (i < leftLen - 1) {
				a = reverse(a, i, (leftLen - i));
				i++;
			}
			/*
			 * System.out.println("Post left"); System.out.println();
			 * Arrays.stream(a).boxed().forEach(y -> System.out.print(y+","));
			 * System.out.println(); System.out.println("Post Right"); System.out.println();
			 */

			// part2 = x to len -1;
			int rightLen = a.length - 1;
			int j = (a.length - x);
			int k = 0;
			while (j <= rightLen - 1) {
				// System.out.print("start: " + j + ", end: " + (rightLen - k));
				a = reverse(a, j, (rightLen - k));
				/*
				 * System.out.println(); Arrays.stream(a).boxed().forEach(y ->
				 * System.out.print(y+",")); System.out.println();
				 */
				j++;
				k++;
			}

		}

		// Reverse complete array:::
		int len = a.length - 1;
		int i = 0;
		// for (int i = 0; i < len; i++) {
		while (i <= (len / 2)) {
			a = reverse(a, i, len - i);
			/*
			 * System.out.println(); System.out.println("Post Reverse");
			 * Arrays.stream(a).boxed().forEach(y -> System.out.print(y + ","));
			 */
			i++;
		}
		return a;

	}

	private static int[] reverse(int[] a, int startIdx, int endIdx) {
		// TODO Auto-generated method stub
		int temp = a[startIdx];
		a[startIdx] = a[endIdx];
		a[endIdx] = temp;

		return a;

	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * int[] a2 = { 1, 2, 4, 3, 5, 6 }; int x2 = 2; String dir2 = "RIGHT"; a2 =
	 * RotateArray.rotateArray(a2, x2, dir2); System.out.println();
	 * System.out.println(":::::::::::::::Final output:::::::::::::::");
	 * Arrays.stream(a2).boxed().forEach(z -> System.out.print(z)); }
	 */

	public static void main(String[] args) {
		Scanner sr = new Scanner(System.in);
		int t = sr.nextInt();
		while (t > 0) {
			int n = sr.nextInt();
			int x = sr.nextInt();
			String dir = sr.next();
			int ar[] = new int[n];
			for (int i = 0; i < n; i++) {
				ar[i] = sr.nextInt();
			}
			ar = RotateArray.rotateArray(ar, x, dir);
			int index = 0;
			for (int i = 0; i < n; i++) {
				System.out.print(ar[i] + " ");
			}
			System.out.println();

			t = t - 1;
		}
	}

}
