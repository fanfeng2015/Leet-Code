// LeetCode #5 (Longest Palindromic Substring).

// Given a string s, find the longest palindromic substring in s.

// You may assume that the maximum length of s is 1000.

public class LongestPalindromicSubstring {

	private int lo, max;

	public String longestPalindrome(String s) {
		for (int i = 0; i < s.length(); i++) {
			extendOnBothSides(s, i, i);
			extendOnBothSides(s, i, i + 1);
		}
		return s.substring(lo, lo + max);
	}

	private void extendOnBothSides(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		if (max < right - left - 1) {
			lo = left + 1;
			max = right - left - 1;
		}
	}

	// Time complexity is O(n^2).
	// Space complexity is O(1).
	
	// Note: There is an O(n) time, O(n) space algorithm.
	// https://en.wikipedia.org/wiki/Longest_palindromic_substring#Manacher's_algorithm
}
