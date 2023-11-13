import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// LeetCode #398 (Random Pick Index).

// Given an integer array nums with possible duplicates, randomly output the index of a given target number. You can assume that the given
// target number must exist in the array.

// Implement the Solution class:
// - Solution(int[] nums) Initializes the object with the array nums.
// - int pick(int target) Picks a random index i from nums where nums[i] == target. If there are multiple valid i's, then each index should
//   have an equal probability of returning.

public class RandomPickIndex {

	Map<Integer, List<Integer>> map = new HashMap<>();

	public RandomPickIndex(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			map.putIfAbsent(nums[i], new ArrayList<Integer>());
			map.get(nums[i]).add(i);
		}
	}

	public int pick(int target) {
		List<Integer> list = map.get(target);
		return list.get(new Random().nextInt(list.size()));
	}

	// Time complexity is O(n) for constructor, and O(1) for pick().
	// Space complexity is O(n) for constructor, and O(1) for pick().
}
