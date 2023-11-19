import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// LeetCode #170 (Two Sum III - Data Structure Design).

// Design a data structure that accepts a stream of integers and checks if it has a pair of integers that sum up to a particular value.

// Implement the TwoSum class:
// - TwoSum() Initializes the TwoSum object, with an empty array initially.
// - void add(int number) Adds number to the data structure.
// - boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value, otherwise, it returns false.

public class TwoSum3DataStructureDesign {

	public TwoSum3DataStructureDesign() {

	}

	// if there are fewer add() and more find() operations
	Set<Integer> nums = new HashSet<>();
	Set<Integer> sums = new HashSet<>();

	public void add(int number) {
		for (Integer i : nums) {
			sums.add(i + number);
		}
		nums.add(number);
	}

	public boolean find(int value) {
		return sums.contains(value);
	}

	// Time complexity is O(n) for add, and O(1) for find.
	// Space complexity is O(n^2).

	// if there are fewer find() and more add() operations
	Map<Integer, Integer> map = new HashMap<>();

	public void add2(int number) {
		Integer count = map.get(number);
		count = count == null ? 1 : count + 1;
		map.put(number, count);
	}

	public boolean find2(int value) {
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (2 * entry.getKey() == value) {
				if (entry.getValue() >= 2) {
					return true;
				}
			} else if (map.containsKey(value - entry.getKey())) {
				return true;
			}
		}
		return false;
	}

	// Time complexity is O(1) for add, and O(n) for find.
	// Space complexity is O(n).
}
