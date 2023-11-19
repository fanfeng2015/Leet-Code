// LeetCode #16 (3 Sum Closest).

// Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

// Return the sum of the three integers.

// You may assume that each input would have exactly one solution.

import java.util.Arrays;

public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int result = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
				if (sum == target) {
					return sum;
				} else if (sum < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		return result;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n), because of quick sort (for primitive types).
}
