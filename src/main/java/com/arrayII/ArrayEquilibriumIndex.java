package com.arrayII;

/**
 * For a given array/list(ARR) of size 'N,' find and return the 'Equilibrium
 * Index' of the array/list.
 * 
 * Equilibrium Index of an array/list is an index 'i' such that the sum of
 * elements at indices [0 to (i - 1)] is equal to the sum of elements at indices
 * [(i + 1) to (N-1)]. One thing to note here is, the item at the index 'i' is
 * not included in either part.
 * 
 * If more than one equilibrium indices are present, then the index appearing
 * first in left to right fashion should be returned. Negative one(-1) if no
 * such index is present.
 * 
 * Example: Let's consider an array/list Arr = [2, 3, 10, -10, 4, 2, 9] of size,
 * N = 7.
 */

public class ArrayEquilibriumIndex {

    public static int arrayEquilibriumIndex(int[] arr) {
        int equilibriumIndex = -1;

        // Calculate total sum of the array
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
       // System.out.println("totalSum: "+totalSum);

        // Initialize left sum
        int leftSum = 0;

        // Iterate through the array to find equilibrium index
        for (int i = 0; i < arr.length; i++) {
            // Deduct the current element from total sum as it's not part of either side
            totalSum -= arr[i];
            
            // Check if the current index is an equilibrium index
            //System.out.println("totalSum: "+totalSum + "==="+ "leftSum: "+leftSum );
            if (leftSum == totalSum) {
                equilibriumIndex = i;
                break;
            }
            
            // Update left sum for the next iteration
            leftSum += arr[i];
            //System.out.println("leftSum: "+leftSum );
        }

        return equilibriumIndex;
    }

    public static void main(String[] args) {
        int[] a = { 2, 3, 10, -10, 4, 2, 9 };
        System.out.println(arrayEquilibriumIndex(a));
    }

}
