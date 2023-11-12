// LeetCode #1216 (Valid Palindrome III).

// Given a string s and an integer k, return true if s is a k-palindrome.

// A string is k-palindrome if it can be transformed into a palindrome by removing at most k characters from it.

public class ValidPalindrome3 {

	// dp[i][j]: minimum nuber of removals needed to make [i, j] a palindrome.
	//
	// dp[i][j] = dp[i + 1][j - 1], if s[i] == s[j]
	// dp[i][j] = 1 + min(dp[i + 1][j], dp[i][j - 1]), otherwise
	public boolean isValidPalindrome(String s, int k) {
		int n = s.length();
		int[][] dp = new int[n][n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j <= n - 1; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = outOfBound(n, i + 1, j - 1) ? 0 : dp[i + 1][j - 1];
				} else {
					int left = outOfBound(n, i, j - 1) ? 0 : dp[i][j - 1];
					int bottom = outOfBound(n, i + 1, j) ? 0 : dp[i + 1][j];
					dp[i][j] = 1 + Math.min(left, bottom);
				}
			}
		}
		return dp[0][n - 1] <= k;
	}

	private boolean outOfBound(int n, int i, int j) {
		return i < 0 || i >= n || j < 0 || j >= n;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n^2), but can be optimized to O(n).
}
