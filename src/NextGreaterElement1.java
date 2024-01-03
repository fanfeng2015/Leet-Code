import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// LeetCode #496 (Next Greater Element I).

// The next greater element of some element x in an array is the first greater element that is to the right of x in the
// same array.

// You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

// For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element
// of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

// Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

public class NextGreaterElement1 {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		LinkedList<Integer> stack = new LinkedList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && stack.peekLast() < nums2[i]) {
				map.put(stack.pollLast(), nums2[i]);
			}
			stack.offerLast(nums2[i]);
		}
		while (!stack.isEmpty()) {
			map.put(stack.pollLast(), -1);
		}
		int[] result = new int[m];
		for (int i = 0; i < m; i++) {
			result[i] = map.get(nums1[i]);
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}

// [4, 1, 2], [1, 3, 4, 2]
// stack: 4 2
// map: {1: 3, 3: 4}
// map: {1: 3, 3: 4, 4: -1, 2: -1}
