package com.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.function.Function;

/*For a given a string(str), find and return the highest occurring character.

Example:
Input String: "abcdeapapqarr"
Expected Output: 'a'
Since 'a' has appeared four times in the string which happens to be the highest frequency character, the answer would be 'a'.
If there are two characters in the input string with the same frequency, return the character which comes first.

Consider:
Assume all the characters in the given string to be in lowercase always.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= N <= 10^6
Where N is the length of the input string.

Time Limit: 1 second
Sample Input 1:
abdefgbabfba
Sample Output 1:
b
Sample Input 2:
xy
Sample Output 2:
x 
 */
public class HighestOccuringChar {

	public static char highestOccuringChar(String str) {
		// Your code goes here
		HashMap<Character, Integer> occuranceMap = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {

			if (occuranceMap.size() == 0) {
				occuranceMap.put(str.charAt(i), 1);
			} else if (occuranceMap.containsKey(str.charAt(i))) {
				occuranceMap.put(str.charAt(i), occuranceMap.get(str.charAt(i)) + 1);
			} else {
				occuranceMap.put(str.charAt(i), 1);
			}
		}

		Comparator<? super Entry<Character, Integer>> comp = (a, b) -> a.getValue().compareTo(b.getValue());

		return occuranceMap.entrySet().stream().max(comp).get().getKey();
	}

	public static void main(String[] args) {
		System.out.println(HighestOccuringChar.highestOccuringChar("abdefgbabfba"));
	}

}
