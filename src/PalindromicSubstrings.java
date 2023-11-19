// LeetCode #647 (Palindromic Substrings).

// Given a string s, return the number of palindromic substrings in it.

// A string is a palindrome when it reads the same backward as forward.

// A substring is a contiguous sequence of characters within the string.

public class PalindromicSubstrings {

	public int countSubstrings(String s) {
		int count = 0;
		if (s == null || s.length() == 0) {
			return count;
		}
		for (int i = 0; i < s.length(); i++) {
			count += extend(s, i, i);
			count += extend(s, i, i + 1);
		}
		return count;
	}

	private int extend(String s, int left, int right) {
		int count = 0;
		while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
			count++;
			left--;
			right++;
		}
		return count;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(1).
}
