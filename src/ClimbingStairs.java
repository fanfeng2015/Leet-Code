// LeetCode #70 (Climbing Stairs).

// You are climbing a stair case. It takes n steps to reach to the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways
// can you climb to the top?

public class ClimbingStairs {

	public int climbStairs(int n) {
		int oneStepDown = 1, twoStepsDown = 0;
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result = oneStepDown + twoStepsDown;
			twoStepsDown = oneStepDown;
			oneStepDown = result;
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
