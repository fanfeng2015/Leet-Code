import java.util.LinkedList;

// LeetCode #1762 (Buildings With an Ocean View).

// There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings
// in the line.

// The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. 
// Formally, a building has an ocean view if all the buildings to its right have a smaller height.

// Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.

public class BuildingsWithAnOceanView {

	public int[] findBuildings(int[] heights) {
		int max = 0;
		LinkedList<Integer> result = new LinkedList<Integer>();
		result.offerFirst(heights.length - 1);
		for (int i = heights.length - 2; i >= 0; i--) {
			max = Math.max(max, heights[i + 1]);
			if (heights[i] > max) {
				result.offerFirst(i);
			}
		}
		return result.stream().mapToInt(Integer::valueOf).toArray();
	}

	// Time complexity is O(n).
	// Space complexity is O(1), ignoring the extra space due to the required return
	// type in Java.
}
