// LeetCode #1893 (Check if All the Integers in a Range Are Covered). 

// You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of 
// the ith person.

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

}
