import java.util.ArrayList;

// LeetCode #1358 (Number of Substrings Containing All Three Characters).

// Given a string s consisting only of characters a, b and c.

// Return the number of substrings containing at least one occurrence of all these characters a, b and c.

public class NumberOfSubstringsContainingAllThreeCharacters {

	public int numberOfSubstrings(String s) {
		int n = s.length();
		ArrayList<Integer> a = new ArrayList<>(), b = new ArrayList<>(), c = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'a') {
				a.add(i);
			} else if (s.charAt(i) == 'b') {
				b.add(i);
			} else if (s.charAt(i) == 'c') {
				c.add(i);
			}
		}
		int i = 0, j = 0, k = 0, result = 0;
		// between [index, n-1], how many substrings contain at least one occurrence of
		// all these characters a, b and c?
		for (int index = 0; index < n; index++) {
			while (i < a.size() && a.get(i) < index) {
				i++;
			}
			while (j < b.size() && b.get(j) < index) {
				j++;
			}
			while (k < c.size() && c.get(k) < index) {
				k++;
			}
			if (i == a.size() || j == b.size() || k == c.size()) {
				break;
			}
			result += (n - max(a.get(i), b.get(j), c.get(k)));
		}
		return result;
	}

	private int max(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	public int numberOfSubstrings2(String s) {
		int result = 0;
		int[] lastOccur = new int[] { -1, -1, -1 };
		for (int i = 0; i < s.length(); i++) {
			lastOccur[s.charAt(i) - 'a'] = i;
			// between [0, min(...)], how many substrings contain at least one occurrence of
			// all these characters a, b and c?
			result += 1 + min(lastOccur[0], lastOccur[1], lastOccur[2]);
		}
		return result;
	}

	private int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}

// abcabc
// 0 -> +0, 1 -> +0
// 2 -> [0, 1, 2] -> +(1+min) = +1
// 3 -> [3, 1, 2] -> +(1+min) = +2
