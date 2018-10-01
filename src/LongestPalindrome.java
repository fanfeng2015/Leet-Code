import java.util.HashSet;
import java.util.Set;

// LeetCode #409 (Longest Palindrome).

// Given a string which consists of lower-case or upper-case letters, find the 
// length of the longest palindromes that can be built with those letters.

// This is case sensitive, for example "Aa" is not considered a palindrome here.

public class LongestPalindrome {

	public int longestPalindrome(String s) {
		int count = 0;
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (!set.add(s.charAt(i))) {
				count += 2;
				set.remove(s.charAt(i));
			}
		}
		return set.isEmpty() ? count : count + 1;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
