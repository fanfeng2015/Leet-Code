import java.util.HashSet;
import java.util.Set;

// LeetCode #217 (Contains Duplicate).

// Given an array of integers, find if the array contains any duplicates. 

// Your function should return true if any value appears at least twice in the array, 
// and it should return false if every element is distinct.

public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			if (!set.add(i)) {
				return true;
			}
		}
		return false;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
