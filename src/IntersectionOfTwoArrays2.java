import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode 350 (Intersection of Two Arrays II).

// Given two arrays, write a function to compute their intersection.

public class IntersectionOfTwoArrays2 {

	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums1) {
			Integer frequency = map.get(i);
			frequency = frequency == null ? 1 : frequency + 1;
			map.put(i, frequency);
		}
		List<Integer> result = new ArrayList<>();
		for (int i : nums2) {
			Integer frequency = map.get(i);
			if (frequency != null && frequency > 0) {
				result.add(i);
				map.put(i, frequency - 1);
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
