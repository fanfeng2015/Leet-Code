// LeetCode #76 (Minimum Window Substring).

// Given a string S and a string T, find the minimum window in S 
// which will contain all the characters in T in complexity O(n).

// Notes:
// 1. If there is no such window in S that covers all characters in T, return the empty string "".
// 2. If there is such window, you are guaranteed that there will always be only one unique minimum
//    window in S.

public class MinimumWindowSubstring {

	public String minWindow(String s, String t) {
		int[] countMap = new int[128];
		for (char ch : t.toCharArray()) {
			countMap[ch]++;
		}
		int count = t.length();
		int left = 0, right = 0;
		int begin = 0, length = Integer.MAX_VALUE;
		while (right < s.length()) {
			if (countMap[s.charAt(right++)]-- > 0) {
				count--;
			}
			while (count == 0) {
				if (right - left < length) {
					length = right - left;
					begin = left;
				}
				if (countMap[s.charAt(left++)]++ == 0) {
					count++;
				}
			}
		}
		return length == Integer.MAX_VALUE ? "" : s.substring(begin, begin + length);
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
