// LeetCode #33 (Search in Rotated Sorted Array).

// Suppose an array sorted in ascending order is rotated at some pivot unknown to you
// beforehand.

// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

// You are given a target value to search. If found in the array return its index, 
// otherwise return -1.

// You may assume no duplicate exists in the array.

// Your algorithm's runtime complexity must be in the order of O(log n).

public class SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int index = findMax(nums);
		int result = binarySearch(nums, 0, index, target);
		if (result != -1) {
			return result;
		}
		return binarySearch(nums, index + 1, nums.length - 1, target);
	}

	private int findMax(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (nums[left] > nums[mid]) {
				right = mid;
			} else if (nums[mid] > nums[right]) {
				left = mid;
			} else {
				return right;
			}
		}
		return nums[left] >= nums[right] ? left : right;
	}

	private int binarySearch(int[] array, int left, int right, int target) {
		if (left > right) {
			return -1;
		}
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}
