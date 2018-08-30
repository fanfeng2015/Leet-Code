import java.util.HashMap;
import java.util.Map;

// LeetCode #325 (Maximum Size Subarray Sum Equals k).

// Given an array nums and a target value k, find the maximum length of a subarray that 
// sums to k. If there isn't one, return 0 instead.

// Note: The sum of the entire nums array is guaranteed to fit within the 32-bit signed
// integer range.

public class MaximumSizeSubarraySumEqualsK {

	public int maxSubArrayLen(int[] nums, int k) {
		int max = 0;
		int prefixSum = 0;
		Map<Integer, Integer> map = new HashMap<>(); // { prefix: index }
		map.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			if (map.containsKey(prefixSum - k)) {
				max = Math.max(max, i - map.get(prefixSum - k));
			}
			if (!map.containsKey(prefixSum)) {
				map.put(prefixSum, i);
			}
		}
		return max;
	}

}
