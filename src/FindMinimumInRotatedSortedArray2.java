// LeetCode #154 (Find Minimum in Rotated Sorted Array II).

// Suppose an array sorted in ascending order is rotated at some pivot unknown 
// to you beforehand.

// Find the minimum element.

// Assumption: The array may contain duplicates.

public class FindMinimumInRotatedSortedArray2 {

	public int findMin(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (nums[left] > nums[mid]) {
				// array drops on the left
				right = mid;
			} else if (nums[mid] > nums[right]) {
				// array drops on the right
				left = mid;
			} else {
				right--;
			}
		}
		return Math.min(nums[left], nums[right]);
	}

	// Time complexity is O(n) in the worst case, when array is not rotated.
	// Otherwise, time complexity is O(log(n)).
	
	// Space complexity is O(1).
}
