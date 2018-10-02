// LeetCode #55 (Jump Game).

// Given an array of non-negative integers, you are initially positioned at the first
// index of the array.

// Each element in the array represents your maximum jump length at that position.

// Determine if you are able to reach the last index.

public class JumpGame {

	// DP
	// M[i]: from index 0, can jump to index i
	public boolean canJump(int[] array) {
		boolean[] canJump = new boolean[array.length];
		canJump[0] = true;
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (canJump[j] && j + array[j] >= i) {
					canJump[i] = true;
					break;
				}
			}
		}
		return canJump[canJump.length - 1];
	}

	// Time complexity is O(n^2).
	// Space complexity is O(n).

	// Greedy
	public boolean canJump2(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			max = (max < i) ? max : Math.max(max, i + nums[i]);
		}
		return max >= nums.length - 1;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
