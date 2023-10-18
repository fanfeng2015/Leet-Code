import java.util.HashMap;
import java.util.Map;

// LeetCode #974 (Subarray Sums Divisible by K).

// Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum
// divisible by k.

public class SubarraySumsDivisibleByK {

	public int subarraysDivByK(int[] nums, int k) {
		int sum = 0, count = 0;
		Map<Integer, Integer> map = new HashMap<>(); // { sum: count }
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			// Java's % is a remainder operation, not a modular operation.
			// -2 % 5 = -2 (Java), whereas -2 % 5 = 3 (real modular operation)
			// (-2 % 5 + 5) % 5 = 3
			sum = (sum % k + k) % k; // assume k is not 0
			if (map.containsKey(sum)) {
				count += map.get(sum);
			}
			Integer frequency = map.get(sum);
			frequency = (frequency == null) ? 1 : frequency + 1;
			map.put(sum, frequency);
		}
		return count;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
