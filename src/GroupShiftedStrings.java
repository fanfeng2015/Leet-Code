import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode #249 (Group Shifted Strings).

// We can shift a string by shifting each of its letters to its successive letter.
// - For example, "abc" can be shifted to be "bcd".

// We can keep shifting the string to form a sequence.
// - For example, we can keep shifting "abc" to form the sequence: "abc" -> "bcd" -> ... -> "xyz".

// Given an array of strings strings, group all strings[i] that belong to the same shifting sequence. You may return the answer in any
// order. 

public class GroupShiftedStrings {

	// ------------------------------ 2018 ------------------------------
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
	// Space complexity is O(n*l).

	// ------------------------------ 2023 ------------------------------
	public List<List<String>> groupStrings2(String[] strings) {
		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < strings.length; i++) {
			String s = strings[i];
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < s.length(); j++) {
				int diff = s.charAt(j) - s.charAt(0);
				diff = diff < 0 ? diff + 26 : diff;
				sb.append('a' + diff);
			}
			map.putIfAbsent(sb.toString(), new ArrayList<>());
			map.get(sb.toString()).add(s);
		}
		return new ArrayList<>(map.values());
	}

	// Time complexity is O(n*l), where l is the average word length.
	// Space complexity is O(n*l).
}
