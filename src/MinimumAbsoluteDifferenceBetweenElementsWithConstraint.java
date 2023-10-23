import java.util.List;
import java.util.TreeSet;

// LeetCode #2817 (Minimum Absolute Difference Between Elements With Constraint).

// You are given a 0-indexed integer array nums and an integer x.

// Find the minimum absolute difference between two elements in the array that are at least x indices apart.

// In other words, find two indices i and j such that abs(i - j) >= x and abs(nums[i] - nums[j]) is minimized.

// Return an integer denoting the minimum absolute difference between two elements that are at least x indices apart.

public class MinimumAbsoluteDifferenceBetweenElementsWithConstraint {

	public int minAbsoluteDifference(List<Integer> nums, int x) {
		int result = Integer.MAX_VALUE;
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = x; i < nums.size(); i++) {
			set.add(nums.get(i - x));
			Integer higher = set.ceiling(nums.get(i));
			Integer lower = set.floor(nums.get(i));
			if (higher != null) {
				result = Math.min(result, Math.abs(nums.get(i) - higher));
			}
			if (lower != null) {
				result = Math.min(result, Math.abs(nums.get(i) - lower));
			}
		}
		return result;
	}

}

// [5, 3, 2, 10, 15], x = 2

// num = 2, { 5}
// num = 10, { 5, 3 }
// num = 15, { 5, 3, 2 }