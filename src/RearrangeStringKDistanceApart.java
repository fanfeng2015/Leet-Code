import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// LeetCode #358 (Rearrange String k Distance Apart).

// Given a non-empty string s and an integer k, rearrange the string such that 
// the same characters are at least distance k from each other.

// All input strings are given in lower-case letters. If it is not possible to 
// rearrange the string, return an empty string "".

public class RearrangeStringKDistanceApart {

    public String rearrangeString(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			Integer count = map.get(ch);
			count = (count == null) ? 1 : (count + 1);
			map.put(ch, count);
		}

		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
				(a, b) -> (b.getValue() - a.getValue()));
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			maxHeap.offer(entry);
		}

		Map.Entry<Character, Integer> entry = maxHeap.poll();
		StringBuilder[] sbs = new StringBuilder[entry.getValue()];
		for (int i = 0; i < entry.getValue() - 1; i++) {
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
			if (sbs[i].length() < k) {
				return "";
			}
			result.append(sbs[i]);
		}
		return result.toString();
    }
	
}
