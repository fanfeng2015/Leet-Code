import java.util.HashMap;
import java.util.Map;

// LeetCode #325 (Maximum Size Subarray Sum Equals k).

// Given an integer array nums and an integer k, return the maximum length of a subarray that sums to k. 
// If there is not one, return 0 instead.

public class MaximumSizeSubarraySumEqualsK {

	public int maxSubArrayLen(int[] nums, int k) {
		int sum = 0, max = 0;
		Map<Integer, Integer> map = new HashMap<>(); // { sum: earliest index }
		map.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				max = Math.max(max, i - map.get(sum - k));
			}
			if (!map.containsKey(sum)) {
				map.put(sum, i); // if sum is already in the map, do nothing
			}
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
