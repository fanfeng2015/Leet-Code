// LeetCode #724 (Find Pivot Index).
// LeetCode #1991 (Find the Middle Index in Array).

// Given an array of integers nums, calculate the pivot index of this array.

// The pivot index is the index where the sum of all the numbers strictly to the left of the 
// index is equal to the sum of all the numbers strictly to the index's right.

// If the index is on the left edge of the array, then the left sum is 0 because there are no 
// elements to the left. This also applies to the right edge of the array.

// Return the leftmost pivot index. If no such index exists, return -1.

public class FindPivotIndex {

	public int pivotIndex(int[] nums) {
		int sum = 0, prefix = 0;
		for (int num : nums) {
			sum += num;
		}
		for (int i = 0; i < nums.length; i++) {
			if (prefix == sum - nums[i] - prefix) {
				return i;
			}
			prefix += nums[i];
		}
		return -1;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
