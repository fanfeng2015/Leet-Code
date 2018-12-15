// LeetCode #746 (Min Cost Climbing Stairs).

// On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

// Once you pay the cost, you can either climb one or two steps. You need to find minimum 
// cost to reach the top of the floor, and you can either start from the step with index 0, 
// or the step with index 1.

public class MinCostClimbingStairs {

	public int minCostClimbingStairs(int[] cost) {
		int result = 0;
		int oneStepBack = 0, twoStepsBack = 0;
		for (int i = 2; i <= cost.length; i++) {
			result = Math.min(oneStepBack + cost[i - 1], twoStepsBack + cost[i - 2]);
			twoStepsBack = oneStepBack;
			oneStepBack = result;
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
