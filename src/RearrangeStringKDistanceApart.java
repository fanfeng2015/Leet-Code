import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// LeetCode #358 (Rearrange String k Distance Apart).

// Given a non-empty string s and an integer k, rearrange the string such that 
// the same characters are at least distance k from each other.

// All input strings are given in lower-case letters. If it is not possible to 
// rearrange the string, return an empty string "".

public class RearrangeStringKDistanceApart {

	public String rearrangeString(String s, int k) {
		if (s == null || s.length() == 0) {
			return "";
		}
		if (k == 0) {
			return s;
		}

		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			Integer count = map.get(ch);
			count = (count == null) ? 1 : (count + 1);
			map.put(ch, count);
		}

		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
				(a, b) -> (b.getValue() - a.getValue()));
		maxHeap.addAll(map.entrySet());

		Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		while (!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> entry = maxHeap.poll();
			sb.append(entry.getKey());
			entry.setValue(entry.getValue() - 1);
			queue.offer(entry);
			if (queue.size() == k) {
				entry = queue.poll();
				if (entry.getValue() > 0) {
					maxHeap.offer(entry);
				}
			}
		}

		return (sb.length() == s.length()) ? sb.toString() : "";
	}
	
	// Time complexity is O(n*log(n)), but O(n) if the alphabet has fixed size.
	// Space complexity is O(n).
}
