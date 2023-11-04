import java.util.Map;
import java.util.TreeMap;

// LeetCode #1854 (Maximum Population Year).

// You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of 
// the ith person.

// The population of some year x is the number of people alive during that year. The ith person is counted in year x's 
// population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that 
// they die.

// Return the earliest year with the maximum population.

public class MaximumPopulationYear {

	// assumption: 1950 <= birthi < deathi <= 2050
	public int maximumPopulation(int[][] logs) {
		int[] map = new int[101];
		for (int[] log : logs) {
			int birth = log[0], death = log[1];
			map[birth - 1950]++;
			map[death - 1950]--;
		}
		int population = 0, max = 0, year = -1;
		for (int i = 0; i < map.length; i++) {
			population += map[i];
			if (population > max) {
				max = population;
				year = i + 1950;
			}
		}
		return year;
	}

	// Time complexity is O(l + r), where l is the number of logs, and r is
	// the range.
	// Space complexity is O(r).

	public int maximumPopulation2(int[][] logs) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int[] log : logs) {
			int birth = log[0], death = log[1];
			map.put(birth, map.getOrDefault(birth, 0) + 1);
			map.put(death, map.getOrDefault(death, 0) - 1);
		}
		int population = 0, max = 0, year = -1;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			population += entry.getValue();
			if (population > max) {
				max = population;
				year = entry.getKey();
			}
		}
		return year;
	}

	// Time complexity is O(l*log(t) + t), where l is the number of logs, and t is
	// the number of unique timestamps.
	// Space complexity is O(t).
}

// { 1993: 1
//   1999: -1
//   2000: 1
//   2010: -1
// }

// Netflix Phone Interview (2023):

// [1, 2], [2, 5], [3, 4], inclusive of both start and end.

// { 1: 1
//   2: 1
//   3: 0
//   4: -1
//   5: -1
// }
