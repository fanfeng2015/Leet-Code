import java.util.Arrays;

// LeetCode #45 (Jump Game II).

// Given an array of non-negative integers, you are initially positioned at the first
// index of the array.

// Each element in the array represents your maximum jump length at that position.

// Your goal is to reach the last index in the minimum number of jumps.

public class JumpGame2 {

	// DP
	// M[i]: minimum number of jumps to reach i
	public int jump(int[] nums) {
		int n = nums.length;
		int[] minJump = new int[n];
		Arrays.fill(minJump, Integer.MAX_VALUE);
		minJump[0] = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (minJump[j] != Integer.MAX_VALUE && j + nums[j] >= i) {
					minJump[i] = Math.min(minJump[i], minJump[j] + 1);
				}
			}
		}
		return minJump[n - 1] == Integer.MAX_VALUE ? -1 : minJump[n - 1];
	}

	// Time Complexity is O(n^2).
	// Space Complexity is O(n).

	// Greedy
	public int jump2(int[] nums) {
		// cur: the farthest position with jumps
		// next: the farthest reachable position
		int jump = 0, cur = 0, next = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > cur) {
				jump++;
				if (cur == next) {
					return -1;
				}
				cur = next;
			}
			next = Math.max(next, i + nums[i]);
		}
		return jump;
	}

	// Time Complexity is O(n).
	// Space Complexity is O(1).
}
