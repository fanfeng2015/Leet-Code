import java.util.HashSet;
import java.util.Set;

// LeetCode #3 (Longest Substring Without Repeating Characters).

// Given a string s, find the length of the longest substring without repeating characters.

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String input) {
		if (input == null || input.length() == 0) {
			return 0;
		}
		int slow = 0, fast = 0, result = 0;
		Set<Character> set = new HashSet<>();
		while (fast < input.length()) {
			if (set.add(input.charAt(fast))) {
				fast++;
				result = Math.max(result, set.size());
			} else {
				set.remove(input.charAt(slow));
				slow++;
			}
		}
		return result;
	}
    
	// Time complexity is O(n).
	// Space complexity is O(n).    
}
