import java.util.ArrayList;
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
		ArrayList<Integer> list = new ArrayList<>();
		list.add(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > list.get(list.size() - 1)) {
				list.add(nums[i]);
			} else {  // binary search to find the first element that's larger than nums[i]
				int index = binarySearch(list, nums[i]);
				list.set(index, nums[i]);
			}
		}
		return list.size();
	}

	private int binarySearch(ArrayList<Integer> list, int target) {
		int left = 0, right = list.size() - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (list.get(mid) < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).
}
