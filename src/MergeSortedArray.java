// LeetCode #88 (Merge Sorted Array).

// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of
// elements in nums1 and nums2 respectively.

// Merge nums1 and nums2 into a single array sorted in non-decreasing order.

// The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 
// has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and 
// should be ignored. nums2 has a length of n.

public class MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int index = m + n - 1;
		int one = m - 1, two = n - 1;
		while (one >= 0 && two >= 0) {
			if (nums1[one] > nums2[two]) {
				nums1[index--] = nums1[one--];
			} else {
				nums1[index--] = nums2[two--];
			}
		}
		// one < 0 || two < 0
		while (two >= 0) {
			nums1[index--] = nums2[two--];
		}
	}

	// Time complexity is O(m + n).
	// Space complexity is O(1).
}
