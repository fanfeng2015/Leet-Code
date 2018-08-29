import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode #49 (Group Anagrams).

// Given an array of strings, group anagrams together.

// Notes:
// 1. All inputs will be in lower case.
// 2. The order of your output does not matter.

public class GroupAnagrams {

	// first 26 prime numbers
	private int[] PRIMES = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
			101, 103 };

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		Map<Integer, List<String>> map = new HashMap<>();
		for (String s : strs) {
			int key = 1;
			for (int i = 0; i < s.length(); i++) {
				key *= PRIMES[s.charAt(i) - 'a'];
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
