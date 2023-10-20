import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// LeetCode #692 (Top K Frequent Words).

// Given an array of strings words and an integer k, return the k most frequent strings.

// Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency
// by their lexicographical order.

public class TopKFrequentWords {

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], map.getOrDefault(words[i], 0) + 1);
		}
		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, (e1, e2) -> {
			if (e1.getValue() != e2.getValue()) {
				return e1.getValue() - e2.getValue();
			}
			return e2.getKey().compareTo(e1.getKey());
		});
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			minHeap.offer(entry);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		LinkedList<String> result = new LinkedList<>();
		for (int i = k - 1; i >= 0; i--) {
			result.offerFirst(minHeap.poll().getKey());
		}
		return result;
	}

	// Time complexity is O(n + n*log(k)*s + k*log(k)*s) = O(n*log(k)*s), where s is
	// the length of string.
	// Space complexity is O(n*s + k*s).

	// Convert the words array to { word: frequency }, then run Kth largest on the
	// frequency.

	// Solution 1: sort (need a comparator)
	// Solution 2: priority queue
	// Solution 3: quick select (need a comparator)
	// Solution 4: count map
}
