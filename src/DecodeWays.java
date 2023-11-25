// LeetCode #91 (Decode Ways).

// A message containing letters from A-Z can be encoded into numbers using the following mapping:
// - 'A' -> "1"
// - 'B' -> "2"
// - ...
// - 'Z' -> "26"

// To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping
// above (there may be multiple ways). For example, "11106" can be mapped into:
// - "AAJF" with the grouping (1 1 10 6)
// - "KJF" with the grouping (11 10 6)

// Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

// Given a string s containing only digits, return the number of ways to decode it.

// The test cases are generated so that the answer fits in a 32-bit integer.

public class DecodeWays {

	// M[i]: number of ways to decode substring [0, i]
	// M[i] = M[i - 2] + M[i - 1], if substring [i - 1, i] is in [1, 26]
	// M[i] = M[i - 1], otherwise
	public int numDecodeWay(String s) {
		int[] array = new int[s.length()];
		array[0] = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 1; i < s.length(); i++) {
			array[i] = (s.charAt(i) == '0') ? 0 : array[i - 1]; // one digit
			int value = Integer.parseInt(s.substring(i - 1, i + 1)); // two digits
			if (value >= 10 && value <= 26) {
				array[i] += (i == 1) ? 1 : array[i - 2];
			}
		}
		return array[s.length() - 1];
	}

	// Time complexity is O(n).
	// Space complexity is O(n), but obviously can be optimized to O(1).

	// Follow up: LeetCode #639 (Decode Ways II).
}
