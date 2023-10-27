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
}
