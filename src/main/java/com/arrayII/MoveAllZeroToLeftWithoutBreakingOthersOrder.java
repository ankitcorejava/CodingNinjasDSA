package com.arrayII;

import java.util.Arrays;

public class MoveAllZeroToLeftWithoutBreakingOthersOrder {

	public static void moveAllZeroToLeftWithoutBreakingOthersOrder(int[] input) {
        if (input.length == 0) {
            return;
        }

        int z = 0; // Pointer for zero
        int nz = 0; // Pointer for non-zero

        while (nz < input.length) {
            if (input[nz] == 0 && input[z] != 0) {
                swap(input, z, nz);
            }
            if (input[z] == 0) {
                z++;
            }
            nz++;
        }

        Arrays.stream(input).forEach(System.out::println);
    }

	private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 0, 3, 4, 0, 5};
        moveAllZeroToLeftWithoutBreakingOthersOrder(arr);
    }
}
