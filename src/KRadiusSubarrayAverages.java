import java.util.Arrays;

// LeetCode #2090 (K Radius Subarray Averages).

// You are given a 0-indexed array nums of n integers, and an integer k.

// The k-radius average for a subarray of nums centered at some index i with the radius k is the average of
// all elements in nums between the indices i - k and i + k (inclusive). If there are less than k elements
// before or after the index i, then the k-radius average is -1.

// Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered
// at index i.

// The average of x elements is the sum of the x elements divided by x, using integer division. The integer 
// division truncates toward zero, which means losing its fractional part.

public class KRadiusSubarrayAverages {

	public int[] getAverages(int[] nums, int k) {
		if (k == 0) {
			return nums;
		}
		int[] result = new int[nums.length];
		Arrays.fill(result, -1);
		if (k > (nums.length - 1) / 2) { // 5 -> 2, 6 -> 2
			return result;
		}
		long sum = 0;
		int left = 0, right = 0, index = k;
		for (; right < 2 * k + 1; right++) { // k = 3, right = [0, 6], index = 3
			sum += nums[right];
		}
		result[index++] = (int) (sum / (2 * k + 1));
		; // first non -1 element is at index k
		while (right < nums.length) {
			sum -= nums[left++];
			sum += nums[right++];
			result[index++] = (int) (sum / (2 * k + 1));
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
