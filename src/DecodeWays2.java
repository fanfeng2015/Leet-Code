// LeetCode #639 (Decode Ways II).

// A message containing letters from A-Z is being encoded to numbers using the following 
// mapping way: 'A' -> 1, 'B' -> 2, ..., 'Z' -> 26.

// Beyond that, now the encoded string can also contain the character '*', which can be 
// treated as one of the numbers from 1 to 9.

// Given the encoded message containing digits and the character '*', return the total 
// number of ways to decode it.

// Also, since the answer may be very large, you should return the output mod (10^9 + 7).

public class DecodeWays2 {

	private static final int NUM_DIGITS = 9;

	// M[i]: number of ways to decode substring [0, i]
	public int numDecodeWay(String s) {
		long[] array = new long[s.length()];
		array[0] = s.charAt(0) == '0' ? 0 : 1;
		array[0] = s.charAt(0) == '*' ? 9 : array[0];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '*') {
				array[i] = NUM_DIGITS * array[i - 1];
				char prev = s.charAt(i - 1);
				long base = (i == 1) ? 1 : array[i - 2];
				int mult = (prev == '*') ? 15 : (prev == '1') ? 9 : (prev == '2') ? 6 : 0;
				array[i] += base * mult;
			} else if (s.charAt(i - 1) == '*') {
				array[i] = (s.charAt(i) == '0') ? 0 : array[i - 1];
				int cur = s.charAt(i) - '0';
				long base = (i == 1) ? 1 : array[i - 2];
				int mult = (cur >= 0 && cur <= 6) ? 2 : 1;
				array[i] += base * mult;
			} else {
				array[i] = (s.charAt(i) == '0') ? 0 : array[i - 1];
				int value = Integer.parseInt(s.substring(i - 1, i + 1));
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
