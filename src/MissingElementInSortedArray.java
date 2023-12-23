// LeetCode #1060 (Missing Element in Sorted Array).

// Given an integer array nums which is sorted in ascending order and all of its elements are unique and given also an integer k, 
// return the kth missing number starting from the leftmost number of the array.

public class MissingElementInSortedArray {

	public int missingElement(int[] nums, int k) {
		int n = nums.length, left = 0, right = n - 1;
		while (left < right) {
			// int mid = left + (right - left) / 2; // floor
			int mid = right - (right - left) / 2; // ceiling
			if (nums[mid] - nums[0] - mid < k) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}
		int diff = k - (nums[left] - nums[0] - left);
		return nums[left] + diff;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}
