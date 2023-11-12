// LeetCode #516 (Longest Palindromic Subsequence).

// Given a string s, find the longest palindromic subsequence's length in s.

// A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order
// of the remaining elements.

public class LongestPalindromicSubsequence {

	// M[i][j]: length of the longest palindromic subsequence of s in [i, j]
	//
	// M[i][j] = 2 + M[i + 1][j - 1], if s[i] == s[j]
	// M[i][j] = max(M[i + 1][j], M[i][j - 1]), otherwise
	public int longestPalindromeSubseq(String s) {
		int max = 0;
		int[][] M = new int[s.length()][s.length()];
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (i == j) {
					M[i][j] = 1;
				} else if (s.charAt(i) == s.charAt(j)) {
					M[i][j] = M[i + 1][j - 1] + 2;
				} else { // s.charAt(i) != s.charAt(j)
					M[i][j] = Math.max(M[i + 1][j], M[i][j - 1]);
				}
				max = Math.max(max, M[i][j]);
			}
		}
		return max;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n^2), but obviously can be optimized to O(n).
}
