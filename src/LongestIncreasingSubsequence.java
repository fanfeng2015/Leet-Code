import java.util.Arrays;

// LeetCode #300 (Longest Increasing Subsequence).

// Given an unsorted array of integers, find the length of longest increasing subsequence.

public class LongestIncreasingSubsequence {

	// M[i]: the length of longest ascending subsequence, ending at array[i]
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = 1;
		int[] result = new int[nums.length];
		Arrays.fill(result, 1);
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					result[i] = Math.max(result[i], result[j] + 1);
					max = Math.max(result[i], max);
				}
			}
		}
		return max;
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n).

	public int lengthOfLIS2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] helper = new int[nums.length + 1];
		int result = 1;
		helper[1] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int index = find(helper, 1, result, nums[i]);
			if (index == result) { // current largest value < nums[i]
				helper[++result] = nums[i];
			} else {
				helper[index + 1] = nums[i];
			}
		}
		return result;
	}

	// find the largest value that is smaller than target
	private int find(int[] helper, int left, int right, int target) {
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (helper[mid] >= target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).
}
