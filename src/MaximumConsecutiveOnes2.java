import java.util.LinkedList;

// LeetCode #487 (Maximum Consecutive Ones II).

// Given a binary array, find the maximum number of consecutive 1s in this array 
// if you can flip at most one 0.

// Assumptions:
// 1. The input array will only contain 0 and 1.
// 2. The length of input array is a positive integer and will not exceed 10,000.

public class MaximumConsecutiveOnes2 {

	public int findMaxConsecutiveOnes(int[] nums) {
		int zeros = 0, max = 0;
		for (int left = 0, right = 0; right < nums.length; right++) {
			zeros = nums[right] == 0 ? zeros + 1 : zeros;
			while (zeros > 1) { // can be generalized to k
				zeros = nums[left++] == 0 ? zeros - 1 : zeros;
			}
			// guaranteed that range [left, right] contains exactly one (or k) 0
			max = Math.max(max, right - left + 1);
		}
		return max;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

	// Follow up: What if the input numbers come in one by one as an infinite
	// stream?
	// In other words, you can't store all numbers coming from the stream as it's
	// too
	// large to hold in memory.

	public int findMaxConsecutiveOnes2(int[] nums) {
		int max = 0;
		LinkedList<Integer> queue = new LinkedList<>();
		for (int left = 0, right = 0; right < nums.length; right++) {
			if (nums[right] == 0) {
				queue.offerFirst(right);
			}
			if (queue.size() > 1) { // can be generalized to k
				left = queue.pollLast() + 1;
			}
			// guaranteed that range [left, right] contains exactly one (or k) 0
			max = Math.max(max, right - left + 1);
		}
		return max;
	}
}
