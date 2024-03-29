package com.arrayII;

import java.util.Arrays;

public class MountainProblem {

	public static boolean validateMountainProblem(int[] arr) {

	    //int max = Arrays.stream(arr).max().getAsInt();
		int max = Integer.MIN_VALUE;
		int maxidx = 0;
		boolean incStatus = false;
		boolean descStatus = false;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > max) {
				max = arr[i];
				maxidx = i;
			}
		}

		for (int i = 0; i < maxidx; i++) {

			// Checking increasing order
			if ((arr[i] < arr[i + 1])) {
				incStatus = true;
			} else {
				incStatus = false;
				break;
			}
		}

		for (int i = maxidx; i < arr.length - 1; i++) {

			// Checking decreasing order
			if ((arr[i] > arr[i + 1])) {
				descStatus = true;
			} else {
				descStatus = false;
				break;
			}
		}

		if ((incStatus == true) && (descStatus == true)) {
			return true;
		}
		return false;

	}

	public static void main(String[] args) {

		int[] input = { 0, 3, 4, 2, 1 };
		System.out.println("{ 0, 3, 4, 2, 1 }: " + validateMountainProblem(input));

		int[] input2 = { 1, 0, 3, 4, 2, 1 };
		System.out.println(" {1, 0, 3, 4, 2, 1 }: " + validateMountainProblem(input2));

		int[] input3 = { -1, 0, 3, 4, 2, 1 };
		System.out.println(" {-1, 0, 3, 4, 2, 1 }: " + validateMountainProblem(input3));
		
		int[] input4 = { -1, 0, 3, 4, 2, 1 ,5};
		System.out.println("  { -1, 0, 3, 4, 2, 1 ,5}: " + validateMountainProblem(input4));
	}

}
