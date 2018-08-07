import java.util.Arrays;

// LeetCode #205 (Isomorphic Strings).

// Given two strings s and t, determine if they are isomorphic.

// Two strings are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while 
// preserving the order of characters. No two characters may map to the same character
// but a character may map to itself.

public class IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}
		int[] a = new int[256];
		int[] b = new int[256];
		Arrays.fill(a, -1);
		Arrays.fill(b, -1);
		for (int i = 0; i < s.length(); i++) {
			if (a[(int) s.charAt(i)] != b[(int) t.charAt(i)]) {
				return false;
			}
			a[(int) s.charAt(i)] = i;
			b[(int) t.charAt(i)] = i;
		}
		return true;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
