// LeetCode #1980 (Find Unique Binary String).

// Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not
// appear in nums. If there are multiple answers, you may return any of them.

public class FindUniqueBinaryString {

	// the result string differs with each input by at least 1 character
	public String findDifferentBinaryString(String[] nums) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			String str = nums[i];
			sb.append(str.charAt(i) == '0' ? "1" : "0");
		}
		return sb.toString();
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
