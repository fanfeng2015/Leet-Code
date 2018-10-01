import java.util.Arrays;

// LeetCode #14 (Longest Common Prefix).

// Write a function to find the longest common prefix string amongst an array of strings.

public class LongestCommonPrefix {

	// Find the shortest String, and check for existence of each of its character in
	// all other words.
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		// find the shortest string
		int index = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() < min) {
				index = i;
				min = strs[i].length();
			}
		}
		String shortest = strs[index];
		for (int i = 0; i < shortest.length(); i++) {
			for (int j = 0; j < strs.length; j++) {
				if (strs[j].charAt(i) != shortest.charAt(i)) {
					return shortest.substring(0, i);
				}
			}
		}
		return shortest;
	}

	// Time complexity is O(n*k).
	// Space complexity is O(1).

	// Sort first, then check for common prefix of the first an last string.
	public String longestCommonPrefix2(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		Arrays.sort(strs);
		String first = strs[0], last = strs[strs.length - 1];
		int index = 0;
		while (index < first.length() && index < last.length() && first.charAt(index) == last.charAt(index)) {
			index++;
		}
		return strs[0].substring(0, index);
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(k).
}
