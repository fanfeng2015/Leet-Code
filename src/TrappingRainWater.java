// LeetCode #42 (Trapping Rain Water).

// Given n non-negative integers representing an elevation map where the width of each bar is
// 1, compute how much water it can trap after raining.

public class TrappingRainWater {

	public int trap(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int n = array.length, result = 0;
		int[] leftMax = new int[n], rightMax = new int[n];
		leftMax[0] = array[0];
		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], array[i]);
		}
		rightMax[n - 1] = array[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], array[i]);
		}
		for (int i = 0; i < n; i++) {
			result += Math.min(leftMax[i], rightMax[i]) - array[i];
		}
		return result;
	}	
	
	// Time complexity is O(n).
	// Space complexity is O(n).
	
	public int trap2(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int result = 0;
		int left = 0, right = array.length - 1;
		int leftMax = array[left], rightMax = array[right];
		while (left < right) {
			// guaranteed that array[left] <= rightMax[left];
			//   -- array[left] <= leftMax[left]? -> add something to result, don't update leftMax
			//   -- array[left] > leftMax[left]? -> don't add anything to result, update leftMax 
			if (array[left] <= array[right]) {
				result += Math.max(0, leftMax - array[left]);
				leftMax = Math.max(leftMax, array[left]);
				left++;
			} else {
				result += Math.max(0, rightMax - array[right]);
				rightMax = Math.max(rightMax, array[right]);
				right--;
			}
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).	
}
