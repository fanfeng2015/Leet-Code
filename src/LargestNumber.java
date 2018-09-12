import java.util.Arrays;
import java.util.Comparator;

// LeetCode #179 (Largest Number).

// Given a list of non negative integers, arrange them such that they form the largest number.

public class LargestNumber {

	public String largestNumber(int[] nums) {
		String[] strings = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strings[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String one, String two) {
				return (two + one).compareTo(one + two);
			}
		});
		if (strings[0].charAt(0) == '0') {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strings.length; i++) {
			sb.append(strings[i]);
		}
		return sb.toString();
	}

	// Time complexity is O(n*log(n)) + O(n*k).
	// Space complexity is O(n), because of merge sort (for non-primitive types).
}
