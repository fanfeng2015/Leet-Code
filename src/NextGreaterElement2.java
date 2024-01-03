import java.util.LinkedList;

// LeetCode #503 (Next Greater Element II).

// Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next 
// greater number for every element in nums.

// The next greater number of a number x is the first greater number to its traversing-order next in the array, which 
// means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

public class NextGreaterElement2 {

	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		LinkedList<Integer> stack = new LinkedList<>(); // [ index ]
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
				result[stack.pollLast()] = nums[i];
			}
			stack.offerLast(i);
		}
		int i = 0;
		while (!stack.isEmpty() && i < n) {
			if (nums[stack.peekLast()] < nums[i]) {
				result[stack.pollLast()] = nums[i];
			} else {
				i++;
			}
		}
		while (!stack.isEmpty()) {
			result[stack.pollLast()] = -1;
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

// [1, 2, 3, 4, 3]
// stack: [3, 4]
// result: [2, 3, 4]
// stack: [3]
// result: [2, 3, 4, 0, 3]
// stack: []
// result: [2, 3, 4, -1, 3]
