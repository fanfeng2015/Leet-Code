import java.util.Arrays;

// LeetCode #1589 (Maximum Sum Obtained of Any Permutation).

// We have an array of integers, nums, and an array of requests where requests[i] = [starti, endi]. The ith request asks for the
// sum of nums[starti] + nums[starti + 1] + ... + nums[endi - 1] + nums[endi]. Both starti and endi are 0-indexed.

// Return the maximum total sum of all requests among all permutations of nums.

// Since the answer may be too large, return it modulo 10^9 + 7.

public class MaximumSumObtainedOfAnyPermutation {

	public int maxSumRangeQuery(int[] nums, int[][] requests) {
		int n = nums.length, mod = (int) 1e9 + 7;
		int[] map = new int[n]; // [0, ..., n]
		for (int i = 0; i < requests.length; i++) {
			map[requests[i][0]]++;
			if (requests[i][1] + 1 < n) {
				map[requests[i][1] + 1]--;
			}
		}
		// compute the prefix sum to get the histogram
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += map[i];
			map[i] = sum;
		}
		// sort nums and histogram, then add up the multiplications
		Arrays.sort(nums);
		Arrays.sort(map);
		long result = 0;
		for (int i = 0; i < n; i++) {
			result += (long) nums[i] * map[i];
			result %= mod;
		}
		return (int) result;
	}

	// Time complexity is O(r + n*log(n)).
	// Space complexity is O(log(n)), because of quick sort for primitive types.
}

// [1, 1, -1, 0, -1]
// [1, 2, 1, 1, 0]