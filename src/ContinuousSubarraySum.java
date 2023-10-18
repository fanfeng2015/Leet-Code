import java.util.HashMap;
import java.util.Map;

// LeetCode #523 (Continuous Subarray Sum).

// Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

// A good subarray is a subarray where:
// 1. Its length is at least two.
// 2. The sum of the elements of the subarray is a multiple of k.

public class ContinuousSubarraySum {

	public boolean checkSubarraySum(int[] nums, int k) {
		int sum = 0, max = 0;
		Map<Integer, Integer> map = new HashMap<>(); // { sum: earliest index }
		map.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			// Java's % is a remainder operation, not a modular operation.
			sum %= k; // assume k is not 0
			if (map.containsKey(sum) && (i - map.get(sum)) > 1) {
				return true;
			}
			if (!map.containsKey(sum)) {
				map.put(sum, i); // if sum is already in the map, do nothing
			}
		}
		return false;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
