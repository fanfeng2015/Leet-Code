import java.util.HashSet;
import java.util.Set;

// LeetCode #266 (Palindrome Permutation).

// Given a string s, return true if a permutation of the string could form a palindrome and false otherwise.

public class PalindromePermutation {

	public boolean canPermutePalindrome(String s) {
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < s.length(); ++i)
			if (!set.add(s.charAt(i))) {
				set.remove(s.charAt(i));
			}
		return set.size() <= 1;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
