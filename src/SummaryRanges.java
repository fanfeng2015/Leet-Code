import java.util.ArrayList;
import java.util.List;

// LeetCode #228 (Summary Ranges).

// Given a sorted integer array without duplicates, return the summary of its ranges.
// For example, given [0, 1, 2, 4, 5, 7], return ["0->2", "4->5", "7"].

public class SummaryRanges {

	public List<String> summaryRanges(int[] nums) {
		int left = 0;
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= nums.length; i++) {
			if (i == nums.length || (long) nums[i] - nums[i - 1] > 1) {
				result.add(i - 1 == left ? nums[left] + "" : nums[left] + "->" + nums[i - 1]);
				left = i;
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
