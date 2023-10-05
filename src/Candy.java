import java.util.Arrays;

// LeetCode #135 (Candy).

// There are N children standing in a line. Each child is assigned a rating value.

// You are giving candies to these children subjected to the following requirements:
// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.

// What is the minimum candies you must give?

public class Candy {

	// Solution 1
	public int candy(int[] ratings) {
		int[] nums = new int[ratings.length];
		Arrays.fill(nums, 1);
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				nums[i] = nums[i - 1] + 1;
			}
		}
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				nums[i] = Math.max(nums[i], nums[i + 1] + 1);
			}
		}
		int result = 0;
		for (int num : nums) {
			result += num;
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).

	// Solution 2
	private int count(int n) {
		return (n * (n + 1)) / 2;
	}

	public int candy2(int[] ratings) {
		if (ratings.length <= 1) {
			return ratings.length;
		}
		int candies = 0, up = 0, down = 0, oldSlope = 0;
		for (int i = 1; i < ratings.length; i++) {
			int newSlope = (ratings[i] > ratings[i - 1]) ? 1 : (ratings[i] < ratings[i - 1] ? -1 : 0);
			// update candies at the bottom of a mountain
			if ((oldSlope > 0 && newSlope == 0) || (oldSlope < 0 && newSlope >= 0)) {
				// should be max(up, down) + 1, but the bottom of mountain will be double
				// counted in the next mountain, so -1 here
				candies += count(up) + count(down) + Math.max(up, down);
				up = 0;
				down = 0;
			}
			if (newSlope > 0) {
				up++;
			} else if (newSlope < 0) {
				down++;
			} else {
				// if flat, candies have already been updated, only need to increment by 1
				candies++;
			}
			oldSlope = newSlope;
		}
		candies += count(up) + count(down) + Math.max(up, down) + 1; // note the difference here
		return candies;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}