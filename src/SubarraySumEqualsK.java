import java.util.HashMap;
import java.util.Map;

// LeetCode #560 (Subarray Sum Equals K).

// Given an array of integers and an integer k, you need to find the total number of continuous
// subarrays whose sum equals to k.

public class SubarraySumEqualsK {

	public int subarraySum(int[] nums, int k) {
		int sum = 0, count = 0;
		Map<Integer, Integer> map = new HashMap<>(); // { sum: count }
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
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
