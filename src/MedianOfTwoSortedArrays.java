// LeetCode #4 (Median of Two Sorted Arrays).

// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the
// two sorted arrays.

// The overall run time complexity should be O(log (m+n)).

public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n = nums1.length + nums2.length;
		if (n % 2 == 1) {
			return kth(nums1, 0, nums2, 0, n / 2 + 1);
		} else {
			return (double) (kth(nums1, 0, nums2, 0, n / 2) + kth(nums1, 0, nums2, 0, n / 2 + 1)) / 2;
		}
	}

	private int kth(int[] a, int aLeft, int[] b, int bLeft, int k) {
		if (aLeft >= a.length) {
			return b[bLeft + k - 1];
		}
		if (bLeft >= b.length) {
			return a[aLeft + k - 1];
		}
		if (k == 1) {
			return Math.min(a[aLeft], b[bLeft]);
		}
		// compare the k/2-th element in subarray of a, and k/2-th element in subarray
		// of b
		int aMid = aLeft + k / 2 - 1;
		int bMid = bLeft + k / 2 - 1;
		int aVal = aMid >= a.length ? Integer.MAX_VALUE : a[aMid];
		int bVal = bMid >= b.length ? Integer.MAX_VALUE : b[bMid];
		if (aVal <= bVal) {
			return kth(a, aMid + 1, b, bLeft, k - k / 2);
		} else {
			return kth(a, aLeft, b, bMid + 1, k - k / 2);
		}
	}

	// Time complexity is O(log(m+n)).
	// Space complexity is O(log(m+n)).
}
