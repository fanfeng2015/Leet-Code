// LeetCode #41 (First Missing Positive).

// Given an unsorted integer array, find the first missing positive integer.

public class FirstMissingPositive {

	// Idea is to put number x at position x - 1.
	public int firstMissingPositive(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int x = nums[i];
			while (0 < x && x <= n && nums[x - 1] != x) { // swap nums[i] and nums[x - 1]
				int temp = nums[x - 1];
				nums[x - 1] = x;
				x = temp;
			}
		}
		for (int i = 0; i < n; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return n + 1;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
