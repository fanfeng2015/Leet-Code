// LeetCode #162 (Find Peak Element).

// A peak element is an element that is strictly greater than its neighbors.

// Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return
// the index to any of the peaks.

// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a 
// neighbor that is outside the array.

// You must write an algorithm that runs in O(log n) time.

public class FindPeakElement {

	public int findPeakElement(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] <= nums[mid + 1]) {
				left = mid + 1;
			} else { // nums[mid] > nums[mid + 1]
				right = mid;
			}
		}
		return right;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}
