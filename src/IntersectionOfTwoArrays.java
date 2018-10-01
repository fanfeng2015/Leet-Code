import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// LeetCode #349 (Intersection of Two Arrays).

// Given two arrays, write a function to compute their intersection.

// Notes:
// 1. Each element in the result must be unique.
// 2. The result can be in any order.

public class IntersectionOfTwoArrays {

	public int[] intersection(int[] nums1, int[] nums2) {
		List<Integer> result = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for (int i : nums1) {
			set.add(i);
		}
		for (int i : nums2) {
			if (set.remove(i)) {
				result.add(i);
			}
		}
		int[] array = new int[result.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = result.get(i);
		}
		return array;
	}

	// Time complexity is O(m + n).
	// Space complexity is O(m).
}
