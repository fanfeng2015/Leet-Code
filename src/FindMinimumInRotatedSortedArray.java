
// LeetCode #153 (Find Minimum in Rotated Sorted Array).

// Suppose an array sorted in ascending order is rotated at some pivot
// unknown to you beforehand.

// For example, [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].

// Find the minimum element.

// You may assume no duplicate exists in the array.

public class FindMinimumInRotatedSortedArray {

	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int left = 0, right = nums.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (nums[left] > nums[mid]) {
				right = mid;
			} else if (nums[mid] > nums[right]) {
				left = mid;
			} else {
				return nums[left];
			}
		}
		return Math.min(nums[left], nums[right]);
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}
