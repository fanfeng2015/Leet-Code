// LeetCode #1186 (Maximum Subarray Sum with One Deletion).

// Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with at most one element 
// deletion. In other words, you want to choose a subarray and optionally delete one element from it so that there is still at
// least one element left and the sum of the remaining elements is maximum possible.

// Note that the subarray needs to be non-empty after deleting one element.

public class MaximumSubarraySumWithOneDeletion {

	public int maximumSum(int[] arr) {
		int n = arr.length, result = Integer.MIN_VALUE;
		int[] maxEndHere = new int[n], maxStartHere = new int[n];
		for (int i = 0; i < n; i++) {
			maxEndHere[i] = Math.max(arr[i], arr[i] + (i == 0 ? 0 : maxEndHere[i - 1]));
			result = Math.max(result, maxEndHere[i]); // include arr[i], to the left
		}
		for (int i = n - 1; i >= 0; i--) {
			maxStartHere[i] = Math.max(arr[i], arr[i] + (i == n - 1 ? 0 : maxStartHere[i + 1]));
			result = Math.max(result, maxStartHere[i]); // include arr[i], to the right
		}
		for (int i = 1; i <= n - 2; i++) {
			result = Math.max(result, maxEndHere[i - 1] + maxStartHere[i + 1]); // delete arr[i]
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
