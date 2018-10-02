// LeetCode #88 (Merge Sorted Array).

// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
// You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold 
// additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n
// respectively.

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
