// LeetCode #161 (One Edit Distance).

// Given two strings s and t, determine if they are both one edit distance apart.

// Notes: There are 3 possiblities to satisify one edit distance apart:

// 1. Insert a character into s to get t.
// 2. Delete a character from s to get t.
// 3. Replace a character of s to get t.

public class OneEditDistance {

	public boolean isOneEditDistance(String s, String t) {
		int m = s.length(), n = t.length();
		if (Math.abs(m - n) > 1) {
			return false;
		}
		boolean found = false;
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
			} else if (found) {
				return false;
			} else {
				found = true;
				if (m == n) {
					i++;
					j++;
				} else if (m < n) {
					j++;
				} else {
					i++;
				}
			}
		}
		int diff = Math.abs((m - i) - (n - j));
		return (found && diff == 0) || (!found && diff == 1);
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
