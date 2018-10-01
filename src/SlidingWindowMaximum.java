import java.util.Deque;
import java.util.LinkedList;

// LeetCode #239 (Sliding Window Maximum).

// Given an array nums, there is a sliding window of size k which is moving
// from the very left of the array to the very right. You can only see the 
// k numbers in the window. Each time the sliding window moves right by one
// position. Return the max sliding window.

public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[] {};
		}
		int[] result = new int[nums.length - k + 1];
		// a descending deque, but stores indices instead of actual values
		Deque<Integer> linkedList = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			while (linkedList.size() > 0 && nums[linkedList.peekLast()] < nums[i]) {
				linkedList.pollLast();
			}
			if (linkedList.size() > 0 && linkedList.peekFirst() <= i - k) {
				linkedList.pollFirst();
			}
			linkedList.offerLast(i);
			if (i >= k - 1) {
				result[i - k + 1] = nums[linkedList.peekFirst()];
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(k).

	// Note: Using priority queue, time complexity is O(n*k), because remove(...)
	// take O(k) time.

}
