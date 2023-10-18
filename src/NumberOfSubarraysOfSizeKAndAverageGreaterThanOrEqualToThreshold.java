// LeetCode #1343 (Number of Subarrays of Size K and Average Greater than or Equal to Threshold).

// Given an array of integers arr and two integers k and threshold, return the number of sub-arrays of size
// k and average greater than or equal to threshold.

public class NumberOfSubarraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {

	public int numOfSubarrays(int[] arr, int k, int threshold) {
		int left = 0, right = 0, sum = 0, count = 0;
		for (; right < k; right++) {
			sum += arr[right];
		}
		count = (sum >= k * threshold) ? count + 1 : count;
		while (right < arr.length) {
			sum -= arr[left++];
			sum += arr[right++];
			count = (sum >= k * threshold) ? count + 1 : count;
		}
		return count;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
