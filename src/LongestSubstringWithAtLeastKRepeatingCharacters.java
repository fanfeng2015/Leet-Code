// LeetCode #395 (Longest Substring with At Least K Repeating Characters).

// Find the length of the longest substring T of a given string (consists of lower-case letters only) 
// such that every character in T appears no less than k times.

public class LongestSubstringWithAtLeastKRepeatingCharacters {

	public int longestSubstring(String s, int k) {
		return longestSubstring(s, k, 0, s.length() - 1);
	}

	private int longestSubstring(String s, int k, int left, int right) {
		if (right - left + 1 < k) {
			return 0;
		}
		int[] count = count(s, left, right);
		for (int i = 0; i < 26; i++) {
			if (0 < count[i] && count[i] < k) {
				for (int j = left; j <= right; j++) {
					if (s.charAt(j) == 'a' + i) {
						return Math.max(longestSubstring(s, k, left, j - 1), longestSubstring(s, k, j + 1, right));
					}
				}
			}
		}
		// up to this point, every character has count >= k
		return right - left + 1;
	}

	private int[] count(String s, int left, int right) {
		int[] count = new int[26];
		for (int i = left; i <= right; i++) {
			count[s.charAt(i) - 'a']++;
		}
		return count;
	}

	// Worst case is s = "abcdefg", k = 2.
	// Time complexity is O(n^2).
	// Space complexity is O(n), because of call-stack.

	// See LeetCode discussion for O(n) time solution, hard to understand...
}
