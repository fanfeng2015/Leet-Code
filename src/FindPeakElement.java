// LeetCode #162 (Find Peak Element).

// A peak element is an element that is greater than its neighbors.

// Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

// The array may contain multiple peaks, in that case return the index to any one of the 
// peaks is fine.

// You may imagine that num[-1] and num[n] equal negative infinity.

// For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return 
// the index number 2.

public class FindPeakElement {

	public int findPeakElement(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] > nums[mid + 1]) {
				right = mid;
			} else if (nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			}
		}
		return left;
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}
