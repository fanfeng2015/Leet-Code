import java.util.Arrays;

// LeetCode #45 (Jump Game II).

// You are given a 0-indexed array of integers nums of length n. You are initially positioned at 
// nums[0].

// Each element nums[i] represents the maximum length of a forward jump from index i. In other words, 
// if you are at nums[i], you can jump to any nums[i + j] where:

// 1. 0 <= j <= nums[i], and
// 2. i + j < n

// Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you
// can reach nums[n - 1].

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
		// curEnd: the farthest position with current number of jumps
		// curFur: the farthest reachable position
		int jump = 0, curEnd = 0, curFur = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			curFur = Math.max(curFur, i + nums[i]); // either jump from i, or not
			if (curEnd == i) { // with the current number of jumps, can only reach i
				jump++; // then take one more jump, and the further you can reach is curFur
				curEnd = curFur;
			}
		}
		return jump;
	}

	// Time Complexity is O(n).
	// Space Complexity is O(1).
}
