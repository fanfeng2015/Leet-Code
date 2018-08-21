// LeetCode #647 (Palindromic Substrings).

// Given a string, your task is to count how many palindromic substrings 
// in this string.

// The substrings with different start indexes or end indexes are counted 
// as different substrings even they consist of same characters.

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
