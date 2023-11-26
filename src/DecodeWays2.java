// LeetCode #639 (Decode Ways II).

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

// In addition to the mapping above, an encoded message may contain the '*' character, which can represent any digit from '1'
// to '9' ('0' is excluded). For example, the encoded message "1*" may represent any of the encoded messages "11", "12", "13",
// "14", "15", "16", "17", "18", or "19". Decoding "1*" is equivalent to decoding any of the encoded messages it can represent.

// Given a string s consisting of digits and '*' characters, return the number of ways to decode it.

// Since the answer may be very large, return it modulo 109 + 7.

public class DecodeWays2 {

	private static final int NUM_DIGITS = 9;

	// M[i]: number of ways to decode substring [0, i]
	public int numDecodeWay(String s) {
		long[] array = new long[s.length()];
		array[0] = s.charAt(0) == '0' ? 0 : 1;
		array[0] = s.charAt(0) == '*' ? 9 : array[0];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '*') {
				array[i] = NUM_DIGITS * array[i - 1]; // one digit
				char prev = s.charAt(i - 1); // two digits
				long base = (i == 1) ? 1 : array[i - 2];
				int mult = (prev == '*') ? 15 : (prev == '1') ? 9 : (prev == '2') ? 6 : 0;
				array[i] += base * mult;
			} else if (s.charAt(i - 1) == '*') {
				array[i] = (s.charAt(i) == '0') ? 0 : array[i - 1]; // one digit
				int cur = s.charAt(i) - '0'; // two digits
				long base = (i == 1) ? 1 : array[i - 2];
				int mult = (cur >= 0 && cur <= 6) ? 2 : 1;
				array[i] += base * mult;
			} else {
				array[i] = (s.charAt(i) == '0') ? 0 : array[i - 1]; // ont sigit
				int value = Integer.parseInt(s.substring(i - 1, i + 1)); // two digits
				if (value >= 10 && value <= 26) {
					array[i] += (i == 1) ? 1 : array[i - 2];
				}
			}
			array[i] %= ((int) Math.pow(10, 9) + 7);
		}
		return (int) array[s.length() - 1];
	}

	// Time complexity is O(n).
	// Space complexity is O(n), but obviously can be optimized to O(1).
}
