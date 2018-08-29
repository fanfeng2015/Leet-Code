import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode #249 (Group Shifted Strings).

// Given a string, we can "shift" each of its letter to its successive letter, for 
// example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
// "abc" -> "bcd" -> ... -> "xyz"

// Given a list of strings which contains only lower case alphabets, group all strings
// that belong to the same shifting sequence.

public class GroupShiftedStrings {

	// first 26 prime numbers
	private static int[] PRIMES = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
			89, 97, 101, 103 };

	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> result = new ArrayList<List<String>>();
		Map<Integer, List<String>> map = new HashMap<>();
		for (int i = 0; i < strings.length; i++) {
			String s = strings[i];
			int key = 1;
			for (int j = 0; j < s.length(); j++) {
				int index = s.charAt(j) - s.charAt(0);
				index = (index < 0) ? (index + 26) : index;
				key *= PRIMES[index];
			}

			if (map.containsKey(key)) {
				map.get(key).add(s);
			} else {
				List<String> list = new ArrayList<>();
				list.add(s);
				map.put(key, list);
				result.add(list);
			}
		}
		return result;
	}

	// Time complexity is O(n*l), where l is the average word length.
	// Space complexity is O(n).
}
