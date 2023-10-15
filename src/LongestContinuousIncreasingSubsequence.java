// LeetCode #674 (Longest Continuous Increasing Subsequence).

// Given an unsorted array of integers nums, return the length of the longest continuous increasing 
// subsequence (i.e. subarray). The subsequence must be strictly increasing.

public class LongestContinuousIncreasingSubsequence {

	public int findLengthOfLCIS(int[] nums) {
		int slow = 0, fast = 0, result = 0;
		for (; fast < nums.length; fast++) {
			if (fast == 0 || nums[fast] > nums[fast - 1]) {
				continue;
			}
			result = Math.max(result, fast - slow);
			slow = fast;
		}
		return Math.max(result, fast - slow);
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
