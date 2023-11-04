import java.util.TreeMap;

// LeetCode #2237 (Count Positions on Street with Required Brightness).

// You are given an integer n. A perfectly straight street is represented by a number line ranging from 0 to n - 1. You are given a 2D
// integer array lights representing the street lamp(s) on the street. Each lights[i] = [positioni, rangei] indicates that there is a 
// street lamp at position positioni that lights up the area from [max(0, positioni - rangei), min(n - 1, positioni + rangei)] (inclusive).

// The brightness of a position p is defined as the number of street lamps that light up the position p. You are given a 0-indexed integer
// array requirement of size n where requirement[i] is the minimum brightness of the ith position on the street.

// Return the number of positions i on the street between 0 and n - 1 that have a brightness of at least requirement[i].

public class CountPositionsOnStreetWithRequiredBrightness {

	public int meetRequirement(int n, int[][] lights, int[] requirement) {
		int[] map = new int[n + 1];
		for (int[] light : lights) {
			int left = Math.max(0, light[0] - light[1]);
			int right = Math.min(n - 1, light[0] + light[1]);
			map[left]++;
			map[right + 1]--; // for light [a, b], both a and b are inclusive
		}
		int count = 0, result = 0;
		for (int i = 0; i < n; i++) {
			count += map[i];
			result = (count >= requirement[i]) ? result + 1 : result;
		}
		return result;
	}

	// Time complexity is O(l + n).
	// Space complexity is O(n).

	public int meetRequirement2(int n, int[][] lights, int[] requirement) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int[] light : lights) {
			int left = Math.max(0, light[0] - light[1]);
			int right = Math.min(n - 1, light[0] + light[1]);
			map.put(left, map.getOrDefault(left, 0) + 1);
			map.put(right + 1, map.getOrDefault(right + 1, 0) - 1);
		}
		int count = 0, result = 0;
		for (int i = 0; i < n; i++) {
			count += map.getOrDefault(i, 0);
			result = (count >= requirement[i]) ? result + 1 : result;
		}
		return result;
	}

	//
	// Time complexity is O(l*log(n) + n*log(n)), where l is the number of lights,
	// and n is the range.
	// Space complexity is O(n).
}
