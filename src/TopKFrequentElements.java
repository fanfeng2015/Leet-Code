import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// LeetCode #347 (Top K Frequent Elements).

// Given an integer array nums and an integer k, return the k most frequent elements. You may return the 
// answer in any order.

public class TopKFrequentElements {

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			Integer count = map.get(nums[i]);
			count = (count == null) ? 1 : count + 1;
			map.put(nums[i], count);
		}
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k,
				(e1, e2) -> (e1.getValue() - e2.getValue()));
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			minHeap.offer(entry);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = minHeap.poll().getKey();
		}
		return result;
	}

	// Time complexity is O(n + n*log(k) + k*log(k)) = O(n*log(k)).
	// Space complexity is O(n + k).

	// Convert the nums array to { value: frequency }, then run Kth largest on the
	// frequency.

	// Solution 1: sort
	// Solution 2: priority queue
	// Solution 3: quick select
	// Solution 4: count map	
}
