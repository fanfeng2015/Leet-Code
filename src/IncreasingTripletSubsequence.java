// LeetCode #334 (Increasing Triplet Subsequence).

// Given an unsorted array return whether an increasing subsequence of length 3 exists
// or not in the array.

public class IncreasingTripletSubsequence {

	public boolean increasingTriplet(int[] nums) {
		int min = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= min) {
				min = nums[i];
			} else if (nums[i] <= secondMin) {
				secondMin = nums[i];
			} else {
				return true;
			}
		}
		return false;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
