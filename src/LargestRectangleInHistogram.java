import java.util.LinkedList;

// LeetCode #84 (Largest Rectangle in Histogram).

// Given an array of integers heights representing the histogram's bar height where the width of each
// bar is 1, return the area of the largest rectangle in the histogram.

public class LargestRectangleInHistogram {

	// For non-decreasing sequence, you can possibly extent rectangle to the right,
	// so keep adding to stack.

	// Once a decreasing sequence is found, any higher histogram in the past can't
	// extend to the right, so compute area by forming rectangle to the left.
	public int largestRectangleArea(int[] heights) {
		int area = 0;
		LinkedList<Integer> stack = new LinkedList<>();
		stack.offerFirst(-1); // left boundary (not including)
		for (int i = 0; i <= heights.length; i++) { // <= to handle the final sequence
			int cur = (i == heights.length) ? 0 : heights[i];
			while (stack.peekFirst() != -1 && heights[stack.peekFirst()] > cur) {
				int height = heights[stack.pollFirst()];
				int left = stack.peekFirst();
				area = Math.max(area, height * (i - left - 1)); // i is right boundary (not including)
			}
			stack.offerFirst(i);
		}
		return area;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
