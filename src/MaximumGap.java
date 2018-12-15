import java.util.Arrays;

// LeetCode #164 (Maximum Gap).

// Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
// Try to solve it in linear time and linear space.

// Return 0 if the array contains less than 2 elements.
// You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.

public class MaximumGap {

	// idea of bucket sort
	public int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		int min = nums[0], max = nums[0];
		for (int i = 0; i < nums.length; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		if (max == min) {
			return 0;
		}
		int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
		int[] lo = new int[nums.length];
		int[] hi = new int[nums.length];
		Arrays.fill(lo, Integer.MAX_VALUE);
		Arrays.fill(hi, Integer.MIN_VALUE);
		for (int i = 0; i < nums.length; i++) {
			int index = (nums[i] - min) / gap;
			lo[index] = Math.min(lo[index], nums[i]);
			hi[index] = Math.max(hi[index], nums[i]);
		}
		int result = 0;
		int prevMax = hi[0];
		for (int i = 1; i < nums.length; i++) {
			if (lo[i] != Integer.MAX_VALUE) {
				result = Math.max(result, lo[i] - prevMax);
				prevMax = hi[i];
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
