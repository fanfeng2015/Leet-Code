// LeetCode #340 (Longest Substring with At Most K Distinct Characters).

// Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct
// characters.

public class LongestSubstringWithAtMostKDistinctCharacters {

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int max = 0, lo = 0;
		int count = 0;
		int[] countMap = new int[256];
		for (int i = 0; i < s.length(); i++) {
			if (countMap[s.charAt(i)]++ == 0) {
				count++;
			}
			if (count <= k) {
				max = Math.max(max, i - lo + 1);
			}
			while (count > k) {
				if (countMap[s.charAt(lo++)]-- == 1) {
					count--;
				}
			}
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
