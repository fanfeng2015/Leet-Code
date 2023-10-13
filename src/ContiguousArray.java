import java.util.HashMap;
import java.util.Map;

// LeetCode #525 (Contiguous Array).

// Given a binary array nums, return the maximum length of a contiguous subarray with an equal number
// of 0 and 1.

public class ContiguousArray {

	public int findMaxLength(int[] nums) {
		int sum = 0, length = 0;
		Map<Integer, Integer> sumToIndex = new HashMap<>();
		sumToIndex.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			sum += (nums[i] == 1) ? 1 : -1;
			if (sumToIndex.containsKey(sum)) {
				length = Math.max(length, i - sumToIndex.get(sum));
			} else {
				sumToIndex.put(sum, i);
			}
		}
		return length;
	}

	// Time complexity is O(n)
	// Space complexity is O(n).
}
