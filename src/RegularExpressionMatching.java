// LeetCode #10 (Regular Expression Matching).

// Implement regular expression matching with support for '.' and '*'.
// '.' Matches any single character.
// '*' Matches zero or more of the preceding element.

// The matching should cover the entire input string (not partial).

public class RegularExpressionMatching {

	// M[i][j]: whether s[0, ..., i - 1] can be matched by p[0, ..., j - 1]
	public boolean isMatch(String s, String p) {
		int m = s.length(), n = p.length();
		boolean[][] M = new boolean[m + 1][n + 1];
		M[0][0] = true;
		// first row
		for (int j = 1; j <= n; j++) {
			// assumption: * is not the first character, and must follow some
			// other character
			M[0][j] = (p.charAt(j - 1) == '*' && M[0][j - 2]);
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
					M[i][j] = M[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					// assumption: * is not the first character, and must follow some other character
					// * is 0 preceding element (that means the preceding element appears 0 times!)
					M[i][j] = M[i][j - 2]; 
					if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
						M[i][j] = M[i][j] || M[i - 1][j];
					}
				}
			}
		}
		return M[m][n];
	}

	// Time complexity is O(m*n).
	// Space complexity is O(m*n), but obviously can be optimized to O(n).
}

//        i-1.     j-1
// 'xxxxxab', 'xxx?*'
// * = 0, [0, i-1] == [0, j-3]?
// * = 1 or more
//   -- ? has to be '.' or 'b', then s[i-1] is matched, [0, i-2] == [0, j-1]?
