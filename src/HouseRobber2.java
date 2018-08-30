// LeetCode #213 (House Robber II).

// After robbing those houses on that street, the thief has found himself a new place for his 
// thievery so that he will not get too much attention. This time, all houses at this place are
// arranged in a circle. 

// That means the first house is the neighbor of the last one. Meanwhile, the security system 
// for these houses remain the same as for those in the previous street.

// Given a list of non-negative integers representing the amount of money of each house, determine
// the maximum amount of money you can rob tonight without alerting the police.

public class HouseRobber2 {

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		return Math.max(nums[0] + rob(nums, 2, nums.length - 2), rob(nums, 1, nums.length - 1));
	}

	private int rob(int[] nums, int left, int right) {
		int even = 0, odd = 0;
		for (int i = left; i <= right; i++) {
			if (i % 2 == 0) {
				even = Math.max(even + nums[i], odd);
			} else {
				odd = Math.max(odd + nums[i], even);
			}
		}
		return Math.max(even, odd);
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
