import java.util.PriorityQueue;

// LeetCode #1985 (Find the Kth Largest Integer in the Array).

// You are given an array of strings nums and an integer k. Each string in nums represents an integer without
// leading zeros.

// Return the string that represents the kth largest integer in nums.

public class FindTheKthLargestIntegerInTheArray {
	// LeetCode #215 (Kth Largest Element in an Array).

	// Solution 1: sort, but need a custom comparator

	// Solution 2: priority queue, find the custom comparator below
	public String kthLargestNumber(String[] nums, int k) {
		PriorityQueue<String> minHeap = new PriorityQueue<>(k, (s1, s2) -> {
			if (s1.length() == s2.length()) {
				return s1.compareTo(s2);
			}
			return s1.length() - s2.length();
		});
		for (int i = 0; i < nums.length; i++) {
			minHeap.offer(nums[i]);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		return minHeap.peek();
	}

	// Time complexity is O(n*log(k)*s), where s is the length of string.
	// Space complexity is O(k*s).

	// Solution 3: quick select, but need a method to compare two strings
	@SuppressWarnings("unused")
	private int compare(String s1, String s2) {
		if (s1.length() == s2.length()) {
			return s1.compareTo(s2);
		}
		return s1.length() - s2.length();
	}

	// Solution 4: count map, but range can be infinitely large
}
