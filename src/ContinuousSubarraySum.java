import java.util.HashMap;
import java.util.Map;

// LeetCode #523 (Continuous Subarray Sum).

// Given a list of non-negative numbers and a target integer k, write a function to check 
// if the array has a continuous subarray of size at least 2 that sums up to the multiple
// of k, that is, sums up to n*k where n is also an integer.

public class ContinuousSubarraySum {

	public boolean checkSubarraySum(int[] nums, int k) {
		int prefixSum = 0;
		Map<Integer, Integer> prefixSums = new HashMap<>();
		prefixSums.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			if (k != 0) {
				prefixSum = prefixSum % k; // Java's % is a remainder operation, not a modular operation
			}
			if (prefixSums.containsKey(prefixSum) && (i - prefixSums.get(prefixSum)) > 1) {
				return true;
			}
			Integer index = prefixSums.get(prefixSum);
			index = (index == null) ? i : index; // keep the earliest (shortest) prefix sum
			prefixSums.put(prefixSum, index);
		}
		return false;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
