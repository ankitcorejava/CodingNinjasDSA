package com.Test2;

public class CheckSequence {

    public static boolean checkSequence(String a, String b) {
        if (b.isEmpty()) {
            return true; // Base case: If b is empty, all characters of b have been found in a
        }
        
        if (a.isEmpty()) {
            return false; // Base case: If a is empty but b is not, characters of b are not found in a
        }
        
        char firstCharB = b.charAt(0);
        char firstCharA = a.charAt(0);

        if (firstCharA == firstCharB) {
            // If the first characters match, recursively check the rest of the strings
            return checkSequence(a.substring(1), b.substring(1));
        } else {
            // If the first characters don't match, continue searching for the first character of b in the rest of a
            return checkSequence(a.substring(1), b);
        }
    }

    public static void main(String[] args) {
        // Example usage:
        System.out.println(checkSequence("abchjsgsuohhdhyrikkknddg", "coding")); // true
        System.out.println(checkSequence("abcde", "aeb")); // false
        System.out.println(checkSequence("opmkaugygagagdnmcds4tr3ht3iudhdushhakhdfgdfaahahdfyttadrwq", "manishakhattar")); // true
    }
}
