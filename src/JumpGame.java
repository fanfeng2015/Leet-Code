// LeetCode #55 (Jump Game).

// Given an array of non-negative integers, you are initially positioned at the first
// index of the array.

// Each element in the array represents your maximum jump length at that position.

// Determine if you are able to reach the last index.

public class JumpGame {

	// Greedy
	public boolean canJump(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			max = (max < i) ? max : Math.max(max, i + nums[i]);
		}
		return max >= nums.length - 1;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
