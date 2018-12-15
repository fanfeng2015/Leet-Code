import java.util.HashMap;
import java.util.Map;

// LeetCode #170 (Design Two Sum)

// Design and implement a TwoSum class. It should support the following operations: add and find.
// 1. add - Add the number to an internal data structure.
// 2. find - Find if there exists any pair of numbers which sum is equal to the value.

// Take-away for this problem: Do we want to optimize add() or find()?
// We can either make add() O(1) and find() O(n), by storing all numbers in a hash table, or
// make add() O(n) and find() O(1) by storing all possible sums in a hash table.

public class DesignTwoSum {

	Map<Integer, Integer> countMap;

	public DesignTwoSum() {
		this.countMap = new HashMap<Integer, Integer>();
	}

	public void add(int number) {
		Integer count = countMap.get(number);
		count = (count == null) ? 1 : count + 1;
		countMap.put(number, count);
	}

	public boolean find(int value) {
		for (int i : countMap.keySet()) {
			Integer count = countMap.get(value - i);
			if (count != null && ((i == value - i && count > 1) || (i != value - i && count > 0))) {
				return true;
			}
		}
		return false;
	}
}