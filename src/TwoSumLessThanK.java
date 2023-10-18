import java.util.Arrays;

// LeetCode #1099 (Two Sum Less Than K).

// Given an array nums of integers and integer k, return the maximum sum such that there exists i < j with
// nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1.

public class TwoSumLessThanK {

	// Solution 1: sort + two pointers
	public int twoSumLessThanK(int[] nums, int k) {
		Arrays.sort(nums);
		int left = 0, right = nums.length - 1, max = Integer.MIN_VALUE;
		while (left < right) {
			if (nums[left] + nums[right] >= k) {
				right--;
			} else {
				max = Math.max(max, nums[left++] + nums[right]);
			}
		}
		return (max == Integer.MIN_VALUE) ? -1 : max;
	}

	// Time complexity is O(n*log(n)).
	// Space complexity is O(log(n)), because of quick sort for primitive types in
	// Java.

	private int MAX = 1001;

	// Solution: count map + two pointers
	public int twoSumLessThanK2(int[] nums, int k) {
		int[] freq = new int[MAX];
		for (int i = 0; i < nums.length; i++) {
			freq[nums[i]]++;
		}
		int left = 0, right = MAX - 1, max = Integer.MIN_VALUE;
		while (left <= right) { // count is only necessary for the case of left = right
			if (left + right >= k || freq[right] == 0) {
				right--;
			} else { // left + right <= k && freq[right] > 0
				if (freq[left] > (left < right ? 0 : 1)) {
					max = Math.max(max, left + right);
				}
				left++;
			}
		}
		return (max == Integer.MIN_VALUE) ? -1 : max;
	}

	// Time complexity is O(n+m), where m is the range of possible integer values.
	// Space complexity is O(m).
}
