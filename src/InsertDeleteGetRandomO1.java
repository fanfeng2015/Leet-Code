import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// LeetCode #380 (Insert Delete Get Random O(1)).

// Design a data structure that supports all following operations in average O(1) time:

// insert(val): Inserts an item val to the set if not already present.
// remove(val): Removes an item val from the set if present.
// getRandom(): Returns a random element from current set of elements. Each element must
//              have the same probability of being returned.

public class InsertDeleteGetRandomO1 {

	List<Integer> list;
	Map<Integer, Integer> map;

	public InsertDeleteGetRandomO1() {
		this.list = new ArrayList<>();
		this.map = new HashMap<>();
	}

	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}
		list.add(val);
		map.put(val, list.size() - 1);
		return true;
	}

	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		int index = map.get(val);
		if (index != list.size() - 1) {
			// swap with the last value in list to avoid O(n) time to remove
			map.put(list.get(list.size() - 1), index);
			int temp = list.get(index);
			list.set(index, list.get(list.size() - 1));
			list.set(list.size() - 1, temp);
		}
		list.remove(list.size() - 1);
		map.remove(val);
		return true;
	}

	public int getRandom() {
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
	}

}
