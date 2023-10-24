// LeetCode #256 (Paint House).

// There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of 
// painting each house with a certain color is different. You have to paint all the houses such that no two adjacent 
// houses have the same color.

// The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.

// For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting 
// house 1 with color green, and so on...

// Return the minimum cost to paint all houses.

public class PaintHouse {

	public int minCost(int[][] costs) {
		int m = costs.length, n = costs[0].length;
		int[] prev = costs[0];
		for (int i = 1; i < m; i++) {
			int[] cur = new int[n];
			cur[0] = costs[i][0] + Math.min(prev[1], prev[2]);
			cur[1] = costs[i][1] + Math.min(prev[0], prev[2]);
			cur[2] = costs[i][2] + Math.min(prev[0], prev[1]);
			prev = cur;
		}
		return Math.min(prev[0], Math.min(prev[1], prev[2]));
	}

	// Time complexity is O(n*k).
	// Space complexity is O(k).

	// Space complexity can be optimized to O(1), since we only need to maintain the
	// minimum and second minimum cost (plus their indices) from the prevou row.
}
