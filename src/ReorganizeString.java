import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// LeetCode #767 (Reorganize String).

// Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

// Return any possible rearrangement of s or return "" if not possible.

public class ReorganizeString {

	public String reorganizeString(String S) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : S.toCharArray()) {
			Integer count = map.get(ch);
			count = (count == null) ? 1 : (count + 1);
			if (count > (S.length() - 1) / 2 + 1) {
				return "";
			}
			map.put(ch, count);
		}
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
				(a, b) -> (b.getValue() - a.getValue()));
		maxHeap.addAll(map.entrySet());

		StringBuilder sb = new StringBuilder();
		while (maxHeap.size() >= 2) {
			Map.Entry<Character, Integer> first = maxHeap.poll();
			Map.Entry<Character, Integer> second = maxHeap.poll();
			sb.append(first.getKey());
			sb.append(second.getKey());
			first.setValue(first.getValue() - 1);
			second.setValue(second.getValue() - 1);
			if (first.getValue() > 0) {
				maxHeap.offer(first);
			}
			if (second.getValue() > 0) {
				maxHeap.offer(second);
			}
		}
		if (maxHeap.size() > 0) {
			sb.append(maxHeap.poll().getKey());
		}
		return sb.toString();
	}

	// Time complexity is O(n*log(k)), where n is the length of the string and k is
	// the number of unique characters.
	// Space complexity is O(k).

	public String reorganizeString2(String s) {
		int[] freq = new int[26];
		for (char ch : s.toCharArray()) {
			freq[ch - 'a']++;
		}
		int ch = 0, count = 0;
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > count) {
				ch = i;
				count = freq[i];
			}
		}
		if (count > (s.length() + 1) / 2) {
			return "";
		}
		int index = 0;
		char[] result = new char[s.length()];
		while (freq[ch] > 0) {
			result[index] = (char) (ch + 'a');
			freq[ch]--;
			index += 2;
		}
		for (int i = 0; i < freq.length; i++) {
			while (freq[i] > 0) {
				if (index >= s.length()) {
					index = 1;
				}
				result[index] = (char) (i + 'a');
				freq[i]--;
				index += 2;
			}
		}
		return String.valueOf(result);
	}

	// Time complexity is O(n).
	// Space complexity is O(k), where k is the number of unique characters.
}
