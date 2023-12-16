import java.util.ArrayList;
import java.util.List;

// LeetCode #163 (Missing Ranges).

// You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are within the inclusive
// range.

// A number x is considered missing if x is in the range [lower, upper] and x is not in nums.

// Return the shortest sorted list of ranges that exactly covers all the missing numbers. That is, no element of nums is included in 
// any of the ranges, and each missing number is covered by one of the ranges.

public class MissingRanges {

	// ------------------------------ 2023 ------------------------------
	public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
		List<List<Integer>> result = new ArrayList<>();
		int prev = lower - 1;
		for (int i = 0; i <= nums.length; i++) {
			int cur = (i == nums.length) ? upper + 1 : nums[i];
			if (cur - prev >= 2) {
				List<Integer> list = new ArrayList<>();
				list.add(prev + 1);
				list.add(cur - 1);
				result.add(list);
			}
			prev = cur;
		}
		return result;
	}

	// ------------------------------ 2018 ------------------------------
	List<String> findMissingRanges2(int[] nums, int lower, int upper) {
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
