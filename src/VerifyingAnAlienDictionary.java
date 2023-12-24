// LeetCode #953 (Verifying an Alien Dictionary)

// In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the 
// alphabet is some permutation of lowercase letters.

// Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words
// are sorted lexicographically in this alien language.

public class VerifyingAnAlienDictionary {

	public boolean isAlienSorted(String[] words, String order) {
		for (int i = 0; i < words.length - 1; i++) {
			String cur = words[i], next = words[i + 1];
			if (!isValid(cur, next, order)) {
				return false;
			}
		}
		return true;
	}

	private boolean isValid(String cur, String next, String order) {
		int index = 0;
		while (index < cur.length() && index < next.length() && cur.charAt(index) == next.charAt(index)) {
			index++;
		}
		if (index < cur.length() && index == next.length()) {
			return false;
		}
		if (index < cur.length() && index < next.length()) {
			return validOrder(cur.charAt(index), next.charAt(index), order);
		}
		return true;
	}

	private boolean validOrder(char c1, char c2, String order) {
		Integer i1 = null, i2 = null;
		for (int i = 0; i < order.length(); i++) {
			if (order.charAt(i) == c1) {
				i1 = i;
			} else if (order.charAt(i) == c2) {
				i2 = i;
				if (i1 == null) {
					return false;
				}
			}
		}
		return true;
	}

	// Time complexity is O(n*l).
	// Space complexity is O(1).
}
