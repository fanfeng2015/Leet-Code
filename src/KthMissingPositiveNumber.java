// LeetCode #1539 (Kth Missing Positive Number).

// Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

// Return the kth positive integer that is missing from this array.

public class KthMissingPositiveNumber {

	public int findKthPositive(int[] arr, int k) {
		int index = 0, cur = 0, count = 0;
		while (count < k) {
			cur++;
			if (index >= arr.length || cur != arr[index]) {
				count++;
			} else {
				index++;
			}
		}
		return cur;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	public int findKthPositive2(int[] arr, int k) {
		int left = 0, right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] - mid - 1 < k) {
				left = mid + 1;
			} else { // arr[mid] - mid - 1 >= k
				right = mid - 1;
			}
		}
		return left + k; // arr[right] + (k - (arr[right] - right - 1))
	}

	// Time complexity is O(log(n)).
	// Space complexity is O(1).
}
