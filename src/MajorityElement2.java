import java.util.ArrayList;
import java.util.List;

// LeetCode #229 (Majority Element II).

// Given an integer array of size n, find all elements that appear more than 
// ⌊ n/3 ⌋ times.

// Note: The algorithm should run in linear time and in O(1) space.

public class MajorityElement2 {

	public List<Integer> majorityElement(int[] array) {
		List<Integer> result = new ArrayList<>();
		if (array == null || array.length == 0) {
			return result;
		}
		int candidate1 = array[0], count1 = 0;
		int candidate2 = array[0], count2 = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == candidate1) {
				count1++;
			} else if (array[i] == candidate2) {
				count2++;
			} else if (count1 == 0) {
				candidate1 = array[i];
				count1 = 1;
			} else if (count2 == 0) {
				candidate2 = array[i];
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		count1 = count2 = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == candidate1) {
				count1++;
			} else if (array[i] == candidate2) {
				count2++;
			}
		}
		if (count1 > array.length / 3) {
			result.add(candidate1);
		}
		if (count2 > array.length / 3) {
			result.add(candidate2);
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
