// LeetCode #169 (Majority Element).

// Given an integer array of length L, find the number that occurs more than 0.5 * L times.

// Assumptions:
// 1. The given array is not null or empty
// 2. It is guaranteed there exists such a majority number

public class MajorityElement {

	// Boyer-Moore Majority Vote Algorithm
	public int majorityElement(int[] nums) {
		int element = nums[0], count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == element) {
				count++;
			} else if (count > 0) {
				count--;
			} else {
				element = nums[i];
				count = 1;
			}
		}
		return element;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
