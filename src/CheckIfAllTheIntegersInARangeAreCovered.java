// LeetCode #1893 (Check if All the Integers in a Range Are Covered). 

// You are given a 2D integer array ranges and two integers left and right. Each ranges[i] = [starti, endi] represents an inclusive interval 
// between starti and endi.

// Return true if each integer in the inclusive range [left, right] is covered by at least one interval in ranges. Return false otherwise.

// An integer x is covered by an interval ranges[i] = [starti, endi] if starti <= x <= endi.

public class CheckIfAllTheIntegersInARangeAreCovered {

	public boolean isCovered(int[][] ranges, int left, int right) {
		int[] map = new int[52]; // [0, 51]
		for (int[] range : ranges) {
			map[range[0]]++;
			map[range[1] + 1]--; // both start and end are inclusive
		}
		int count = 0;
		for (int i = 1; i <= 50; i++) {
			count += map[i];
			if (i >= left && i <= right && count <= 0) {
				return false;
			}
		}
		return true;
	}

	// Time complexity is O(m + n).
	// Space complexity is O(m + n).
}
