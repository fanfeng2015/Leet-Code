import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// LeetCode #451 (Sort Characters By Frequency).

// Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number
// of times it appears in the string.

// Return the sorted string. If there are multiple answers, return any of them.

public class SortCharactersByFrequency {

	// Solution 1: Priority Queue
	public String frequencySort(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Integer count = map.get(s.charAt(i));
			count = (count == null) ? 1 : count + 1;
			map.put(s.charAt(i), count);
		}
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
				s.length(), new Comparator<Map.Entry<Character, Integer>>() {
					@Override
					public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
						if (e1.getValue() == e2.getValue()) {
							return 0;
						}
						return e1.getValue() > e2.getValue() ? -1 : 1;
					}
				});
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			maxHeap.offer(entry);
		}
		StringBuilder sb = new StringBuilder();
		while (!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> entry = maxHeap.poll();
			for (int i = 0; i < entry.getValue(); i++) {
				sb.append(entry.getKey());
			}
		}
		return sb.toString();
	}

	// Time complexity is O(n * log(n)).
	// Space complexity is O(n).

	// Solution 2: Bucket Sort
	public String frequencySort2(String s) {
		if (s.length() <= 1) {
			return s;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Integer count = map.get(s.charAt(i));
			count = (count == null) ? 1 : count + 1;
			map.put(s.charAt(i), count);
		}
		@SuppressWarnings("unchecked")
		List<Character>[] buckets = new List[s.length() + 1]; // index is frequency
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			int frequency = entry.getValue();
			if (buckets[frequency] == null) {
				buckets[frequency] = new ArrayList<Character>();
			}
			buckets[frequency].add(entry.getKey());
		}
		StringBuilder sb = new StringBuilder();
		for (int i = buckets.length - 1; i >= 0; i--) {
			if (buckets[i] != null) {
				for (Character ch : buckets[i]) {
					for (int j = 0; j < i; j++) {
						sb.append(ch);
					}
				}
			}
		}
		return sb.toString();
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
