// LeetCode #169 (Majority Element).

// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always
// exists in the array.

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
