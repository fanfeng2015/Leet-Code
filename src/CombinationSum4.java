// LeetCode #377 (Combination Sum IV).

// Given an integer array with all positive numbers and no duplicates, find the number 
// of possible combinations that add up to a positive integer target.

public class CombinationSum4 {

	public int combinationSum4(int[] nums, int target) {
		// M[i]: number of combinations adding up to i
		int[] M = new int[target + 1];
		M[0] = 1;
		for (int i = 1; i <= target; i++) {
			for (int n : nums) {
				M[i] += (i - n >= 0) ? M[i - n] : 0;
			}
		}
		return M[target];
	}

	// Time complexity is O(n*target).
	// Space complexity is O(target).

	// Compare LeetCode #377 (Combination Sum IV) with LeetCode #518 (Coin Change
	// 2).
}

// [1, 2, 3], target = 4

// #518: each coin is grouped together, won't see cases like [1, 2, 1]
// [1, 1, 1, 1, 1] -> (/), (1), (1, 1), (1, 1, 1), (1, 1, 1, 1)
// [1, 1, 2, 2, 3] -> (/), (1), +(2),   +(1, 2),   +(1, 1, 2) or (2, 2)  
// [1, 1, 2, 3, 4] ->                   +(3),      +(1, 3)


// #377: 
// [1, 1, 0, 0, 0] -> (1)
// [1, 1, 2, 0, 0] -> (2) / (1, 1)
// [1, 1, 2, 4, 0] -> (3) or (1, 2) or (2, 1) / (1, 1, 1)
// [1, 1, 2, 4, 7]

// If order doesn't matter, loop coins first.
// If order does matter, loop target first.
