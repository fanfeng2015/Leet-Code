import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;

// LeetCode #791 (Custom Sort String).

// You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.

// Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before
// a character y in order, then x should occur before y in the permuted string.

// Return any permutation of s that satisfies this property.

public class CustomSortString {

	// Solution 1: Comparator
	public String customSortString(String S, String T) {
		Map<Character, Integer> ordering = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			ordering.put(S.charAt(i), i);
		}
		Character[] chars = new Character[T.length()];
		for (int i = 0; i < T.length(); i++) {
			chars[i] = T.charAt(i);
		}
		Arrays.sort(chars, new Comparator<Character>() {
			@Override
			public int compare(Character c1, Character c2) {
				Integer i1 = ordering.get(c1);
				Integer i2 = ordering.get(c2);
				if (i1 == i2) {
					return 0;
				} else if (i1 == null || i2 == null) {
					return i1 == null ? 1 : -1;
				}
				return i1 - i2;
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			sb.append(chars[i]);
		}
		return sb.toString();
	}

	// Time complexity is O(s + t*log(t)).
	// Space complexity is O(c + t), where c is the number of unique characters..

	// Solution 2: Bucket Sort
	public String customSortString2(String S, String T) {
		int[] countMap = new int[26]; // char count of T
		for (int i = 0; i < T.length(); i++) {
			countMap[T.charAt(i) - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			while (countMap[S.charAt(i) - 'a']-- > 0) {
				sb.append(S.charAt(i));
			}
		}
		for (int i = 0; i < countMap.length; i++) {
			while (countMap[i]-- > 0) {
				sb.append((char) ('a' + i));
			}
		}
		return sb.toString();
	}

	// Time complexity is O(s + t).
	// Space complexity is O(c).
}
