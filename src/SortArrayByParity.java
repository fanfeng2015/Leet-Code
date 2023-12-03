// LeetCode #905 (Sort Array By Parity).

// Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

// Return any array that satisfies this condition.

public class SortArrayByParity {

	public int[] sortArrayByParity(int[] nums) {
		int slow = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				swap(nums, slow++, i);
			}
		}
		return nums;
	}

	private void swap(int[] nums, int slow, int fast) {
		int temp = nums[slow];
		nums[slow] = nums[fast];
		nums[fast] = temp;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
