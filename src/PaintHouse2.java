// LeetCode #265 (Paint House II).

// There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house
// with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same
// color.

// The cost of painting each house with a certain color is represented by an n x k cost matrix costs.

// For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1
// with color 2, and so on...

// Return the minimum cost to paint all houses.

public class PaintHouse2 {

	public int minCostII(int[][] costs) {
		int m = costs.length, k = costs[0].length;
		int[] prev = costs[0];
		for (int i = 1; i < m; i++) {
			int[] cur = new int[k];
			for (int j = 0; j < k; j++) {
				cur[j] = costs[i][j] + min(prev, j);
			}
			prev = cur;
		}
		return min(prev, k); // k is out of bound
	}

	private int min(int[] prev, int index) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < prev.length; i++) {
			if (i != index) {
				min = Math.min(min, prev[i]);
			}
		}
		return min;
	}

	// Time complexity is O(n*k).
	// Space complexity is O(k).

	// Space complexity can be optimized to O(1), since we only need to maintain the
	// minimum and second minimum cost (plus their indices) from the prevou row.
}
