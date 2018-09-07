// LeetCode #72 (Edit Distance).

// Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

// You have the following 3 operations permitted on a word:

// 1. Insert a character
// 2. Delete a character
// 3. Replace a character

public class EditDistance {

	// TLE
	// Recursion: using index in string is more efficient than creating substring.
	public int minDistance(String s, String t) {
		return helper(s, t, 0, 0);
	}

	private int helper(String s, String t, int i, int j) {
		int m = s.length(), n = t.length();
		if (i == m) {
			return n - j;
		}
		if (j == n) {
			return m - i;
		}
		int cur = (s.charAt(i) == t.charAt(j)) ? 0 : 1;
		int replace = cur + helper(s, t, i + 1, j + 1);
		int delete = 1 + helper(s, t, i + 1, j);
		int insert = 1 + helper(s, t, i, j + 1);
		return min(replace, delete, insert);
	}

	// Time complexity is O(3^(m+n)).
	// Space complexity is O(m + n).

	// DP
	// M[i][j]: minimum number of operations needed to transfer one in [0, i - 1] to
	// two in [0, j - 1]
	public int minDistance2(String s, String t) {
		if (s.length() == 0) {
			return t.length();
		}
		if (t.length() == 0) {
			return s.length();
		}
		int[][] matrix = new int[s.length() + 1][t.length() + 1];
		for (int i = 0; i < s.length() + 1; i++) {
			for (int j = 0; j < t.length() + 1; j++) {
				if (i == 0) {
					matrix[i][j] = j;
				} else if (j == 0) {
					matrix[i][j] = i;
				} else {
					int cur = (s.charAt(i - 1) == t.charAt(j - 1)) ? 0 : 1;
					matrix[i][j] = min(cur + matrix[i - 1][j - 1], 1 + matrix[i - 1][j], 1 + matrix[i][j - 1]);
				}
			}
		}
		return matrix[s.length()][t.length()];
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n), but obviously can be optimized to O(n).

	private int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

}
