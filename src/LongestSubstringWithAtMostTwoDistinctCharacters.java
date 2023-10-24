// LeetCode #159 (Longest Substring with At Most Two Distinct Characters).

// Given a string s, return the length of the longest substring that contains at most two distinct characters.

public class LongestSubstringWithAtMostTwoDistinctCharacters {

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int max = 0, lo = 0;
		int count = 0;
		int[] countMap = new int[256];
		for (int i = 0; i < s.length(); i++) {
			if (countMap[s.charAt(i)]++ == 0) {
				count++;
			}
			if (count <= 2) {
				max = Math.max(max, i - lo + 1);
			}
			while (count > 2) {
				if (countMap[s.charAt(lo++)]-- == 1) {
					count--;
				}
			}
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	// Follow up: LeetCode #340 (Longest Substring with At Most K Distinct
	// Characters).
}
