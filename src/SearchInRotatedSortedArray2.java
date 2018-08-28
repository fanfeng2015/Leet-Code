// LeetCode #81 (Search in Rotated Sorted Array II).

// Suppose an array sorted in ascending order is rotated at some pivot unknown to you 
// beforehand.

// (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

// You are given a target value to search. If found in the array return true, otherwise
// return false.

public class SearchInRotatedSortedArray2 {

	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[left] == nums[mid]) {
				left++;
			} else if (nums[left] < nums[mid]) { // left half is monotonic
				if (nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else { // nums[left] > nums[mid], right half is nonotonic
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return false;
	}

	// Time complexity is O(n) in the worst case, but O(log(n)) in average case.
	// Space complexity is O(1).
}
