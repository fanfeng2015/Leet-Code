import java.util.ArrayList;
import java.util.List;

// LeetCode #163 (Missing Ranges).

// Given a sorted integer array nums, where the range of elements are in the
// inclusive range [lower, upper], return its missing ranges.

public class MissingRanges {

	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<>();
		long prev = (long) lower - 1;
		for (int i = 0; i <= nums.length; i++) {
			long cur = (i < nums.length) ? nums[i] : (long) upper + 1;
			if (cur - prev == 2) {
				result.add((prev + 1) + "");
			} else if (cur - prev > 2) {
				result.add((prev + 1) + "->" + (cur - 1));
			}
			prev = cur;
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
