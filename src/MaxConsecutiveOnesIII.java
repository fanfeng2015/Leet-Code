// LeetCode #1004 (Max Consecutive Ones III).

// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in 
// the array if you can flip at most k 0's.

public class MaxConsecutiveOnesIII {

	public int longestOnes(int[] nums, int k) {
		int left = 0, right = 0, max = 0;
		for (right = 0; right < nums.length; right++) {
			if (nums[right] == 0) {
				k--; // flip it (0 -> 1)
			}
			if (k >= 0) {
				max = Math.max(max, right - left + 1);
			} else {
				while (left < right && nums[left] == 1) {
					left++;
				}
				k++; // flip back (1 -> 0)
				left++;
			}
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
