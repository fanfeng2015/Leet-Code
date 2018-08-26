import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

// LeetCode #387 (First Unique Character in a String). 

// Given a string, find the first non-repeating character in it and return its index. 
// If it doesn't exist, return -1.

public class FirstUniqueCharacterInAString {

	public int firstUniqChar(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Integer count = map.get(s.charAt(i));
			count = (count == null) ? 1 : count + 1;
			map.put(s.charAt(i), count);
		}
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}

	// Time complexity is O(n).
	// Space complexity is O(n), but is obviously bounded by the number of possible
	// characters.

	// Follow up: What if chars are give as data stream? LinkedHashMap
	public int firstUniqChar2(String s) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (!set.add(s.charAt(i))) {
				map.remove(s.charAt(i));
			} else {
				map.put(s.charAt(i), i);
			}
		}
		return (map.size() == 0) ? -1 : map.entrySet().iterator().next().getValue();
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
