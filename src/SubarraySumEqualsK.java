import java.util.HashMap;
import java.util.Map;

// LeetCode #560 (Subarray Sum Equals K).

// Given an array of integers and an integer k, you need to find the total number of continuous
// subarrays whose sum equals to k.

public class SubarraySumEqualsK {

	public int subarraySum(int[] nums, int target) {
		int count = 0;
		int prefixSum = 0;
		Map<Integer, Integer> prefixSums = new HashMap<>();
		prefixSums.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			if (prefixSums.containsKey(prefixSum - target)) {
				count += prefixSums.get(prefixSum - target);
			}
			Integer frequency = prefixSums.get(prefixSum);
			frequency = (frequency == null) ? 1 : frequency + 1;
			prefixSums.put(prefixSum, frequency);
		}
		return count;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
