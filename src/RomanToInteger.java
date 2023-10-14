import java.util.HashMap;
import java.util.Map;

// LeetCode #13 (Roman to Integer).

// Given a roman numeral, convert it to an integer.

// Input is guaranteed to be within the range from 1 to 3999.

public class RomanToInteger {

	public int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return -1;
		}
		Map<Character, Integer> map = constructMap();
		int result = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (i == s.length() - 1 || map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
				result += map.get(s.charAt(i));
			} else {
				result -= map.get(s.charAt(i));
			}
		}
		return result;
	}

	private Map<Character, Integer> constructMap() {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		return map;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
