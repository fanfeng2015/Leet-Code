// LeetCode #312 (Burst Balloons).

// Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented
// by array nums.

// You are asked to burst all the balloons. If the you burst balloon i you will get 
// nums[left] * nums[i] * nums[right] coins.

// Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

// Find the maximum coins you can collect by bursting the balloons wisely.

public class BurstBalloons {

	// nums = [1, ..., 1], with length = n + 2
	// M[i][j]: max coins collected by bursting the balloons in nums in [i, j]
	public int maxCoins(int[] iNums) {
		int n = iNums.length + 2;
		int[] nums = copy(iNums);
		int[][] M = new int[n][n];
		for (int length = 2; length < n; length++) { // range [left, left + length]
			for (int left = 0; left < n - length; left++) {
				int right = left + length;
				for (int i = left + 1; i < right; i++)
					M[left][right] = Math.max(M[left][right],
							nums[left] * nums[i] * nums[right] + M[left][i] + M[i][right]);
			}
		}
		return M[0][n - 1];
	}

	private int[] copy(int[] iNums) {
		int n = iNums.length;
		int[] nums = new int[n + 2];
		nums[0] = nums[n + 1] = 1;
		for (int i = 0; i < iNums.length; i++) {
			nums[i + 1] = iNums[i];
		}
		return nums;
	}

	// Time complexity is O(n^3).
	// Space complexity is O(n^2).
}