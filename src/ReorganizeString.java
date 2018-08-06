import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// LeetCode #767 (Reorganize String).

// Given a string S, check if the letters can be rearranged so that two characters 
// that are adjacent to each other are not the same.

// If possible, output any possible result. If not possible, return the empty string.

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

	// Time complexity is O(n*log(n)), but O(n) if the alphabet has fixed size.
	// Space complexity is O(n).
}
