import java.util.HashSet;
import java.util.Set;

// LeetCode #219 (Contains Duplicate II).

// Given an array of integers and an integer k, find out whether there are 
// two distinct indices i and j in the array such that nums[i] = nums[j] and 
// the absolute difference between i and j is at most k.

public class ContainsDuplicate2 {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {
				set.remove(nums[i - k - 1]);
			}
			if (!set.add(nums[i])) {
				return true;
			}
		}
		return false;
	}

	// Time complexity is O(n).
	// Space complexity is O(k).
}
