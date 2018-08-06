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
			count = (count == null) ? 1 : count + 1;
			if (count > (S.length() - 1) / 2 + 1) {
				return "";
			}
			map.put(ch, count);
		}
		
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
				(a, b) -> (b.getValue() - a.getValue()));

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			maxHeap.offer(entry);
		}

		Map.Entry<Character, Integer> entry = maxHeap.poll();
		StringBuilder[] sbs = new StringBuilder[entry.getValue()];
		for (int i = 0; i < entry.getValue(); i++) {
			sbs[i] = new StringBuilder();
			sbs[i].append(entry.getKey());
		}

		int index = 0;
		while (!maxHeap.isEmpty()) {
			entry = maxHeap.poll();
			for (int i = 0; i < entry.getValue(); i++) {
				sbs[index].append(entry.getKey());
				index = (index + 1) % sbs.length;
			}
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < sbs.length; i++) {
			result.append(sbs[i]);
		}
		return result.toString();
	}

	// Time complexity is O(n*log(n)), but O(n) if the alphabet has fixed size.
	// Space complexity is O(n), but O(1) if the alphabet has fixed size.
}
