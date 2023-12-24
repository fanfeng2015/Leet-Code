import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// LeetCode #267 (Palindrome Permutation II).

// Given a string s, return all the palindromic permutations (without duplicates) of it.

// You may return the answer in any order. If s has no palindromic permutation, return an empty list.

public class PalindromePermutation2 {

	Character ch;
	char[] chars;

	public List<String> generatePalindromes(String s) {
		if (!canPermutePalindrome(s)) {
			return new ArrayList<String>();
		}
		findAllChars(s);
		List<String> result = new ArrayList<>();
		DFS(0, result);
		return result;
	}

	private boolean canPermutePalindrome(String s) {
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < s.length(); ++i)
			if (!set.add(s.charAt(i))) {
				set.remove(s.charAt(i));
			}
		return set.size() <= 1;
	}

	// "aabb"
	// list = ['a', 'b'], chars = ['a', 'b']
	private void findAllChars(String s) {
		List<Character> list = new ArrayList<>();
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (!set.add(s.charAt(i))) {
				list.add(s.charAt(i));
				set.remove(s.charAt(i));
			}
		}
		ch = !set.isEmpty() ? set.iterator().next() : ch;
		// convert list to array, to able to swap in DFS
		chars = new char[list.size()];
		for (int i = 0; i < list.size(); i++) {
			chars[i] = list.get(i);
		}
	}

	// chars = ['a', 'b']
	// LeetCode #47 (Permutations II).
	private void DFS(int start, List<String> result) {
		if (start == chars.length) {
			StringBuilder firstHalf = new StringBuilder(new String(chars));
			StringBuilder secondHalf = new StringBuilder(new String(chars)).reverse();
			if (ch == null) {
				result.add(firstHalf.append(secondHalf).toString());
			} else {
				result.add(firstHalf.append(ch).append(secondHalf).toString());
			}
			return;
		}
		Set<Character> set = new HashSet<>();
		for (int i = start; i < chars.length; i++) {
			if (set.add(chars[i])) {
				swap(chars, start, i);
				DFS(start + 1, result);
				swap(chars, start, i);
			}
		}
	}

	private void swap(char[] chars, int i, int j) {
		char temp = chars[i];
		chars[i] = chars[j];
		chars[j] = temp;
	}

	// Time complexity is O(n + n*(n-1) + n*(n-1)*(n-2) + ... + n!) = O(n!)
	// Space complexity is O(n) because of call-stack.
}
