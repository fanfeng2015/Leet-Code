import java.util.HashMap;
import java.util.Map;

// LeetCode #383 (Ransom Note).

// Given two strings ransomNote and magazine, return true if ransomNote can be constructed 
// by using the letters from magazine and false otherwise.

// Each letter in magazine can only be used once in ransomNote.

public class RansomNote {

	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) {
			return false;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : ransomNote.toCharArray()) {
			int count = map.getOrDefault(ch, 0);
			map.put(ch, count + 1);
		}
		for (char ch : magazine.toCharArray()) {
			if (map.containsKey(ch)) {
				if (map.get(ch) > 1) {
					map.put(ch, map.get(ch) - 1);
				} else {
					map.remove(ch);
				}
			}
		}
		return map.size() == 0;
	}

	// Time complexity is O(m), where m is the length of magazine.
	// Space complexity is O(m), or O(k), where k is the vocabulary size.
}
