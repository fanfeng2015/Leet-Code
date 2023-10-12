// LeetCode #34 (Find First and Last Position of Element in Sorted Array).

// Given an array of integers nums sorted in non-decreasing order, find the starting and ending 
// position of a given target value.

// If target is not found in the array, return [-1, -1].

public class FindFirstAndLastPositionOfElementInSortedArray {

	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[] { -1, -1 };
		}
		return new int[] { binarySearchFirst(nums, target), binarySearchLast(nums, target) };
	}

	private int binarySearchFirst(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid;
			} else { // key: when equal, move right because you want to keep left
				right = mid;
			}
		}
		return nums[left] == target ? left : (nums[right] == target ? right : -1);
	}

	private int binarySearchLast(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (nums[mid] <= target) { // key: when equal, move left because you want to keep right
				left = mid;
			} else {
				right = mid;
			}
		}
		return nums[right] == target ? right : (nums[left] == target ? left : -1);
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(log(n)).
}
