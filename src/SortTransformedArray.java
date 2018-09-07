// LeetCode #360 (Sort Transformed Array).

// Given a sorted array of integers nums and integer values a, b and c. Apply a quadratic
// function of the form f(x) = ax2 + bx + c to each element x in the array.

// The returned array must be in sorted order.

// Expected time complexity: O(n)

public class SortTransformedArray {

	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		double middle = (double) -b / (2 * a);
		return sort(nums, a, b, c, (a > 0) ? 1 : -1, middle);
	}

	private int[] sort(int[] nums, int a, int b, int c, int delta, double middle) {
		int n = nums.length;
		int[] result = new int[n];
		int i = 0, j = n - 1;
		int index = (delta == 1) ? n - 1 : 0;
		while (i <= j) {
			int left = evaluate(a, b, c, nums[i]);
			int right = evaluate(a, b, c, nums[j]);
			if ((delta * left >= delta * right)) {
				i++;
				result[index] = left;
			} else {
				j--;
				result[index] = right;
			}
			index -= delta;
		}
		return result;
	}

	private int evaluate(int a, int b, int c, int x) {
		return a * x * x + b * x + c;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).
}
