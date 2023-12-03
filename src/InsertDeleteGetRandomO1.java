import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// LeetCode #380 (Insert Delete Get Random O(1)).

// Implement the RandomizedSet class:
// - RandomizedSet() Initializes the RandomizedSet object.
// - bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
// - bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
// - int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when 
//   this method is called). Each element must have the same probability of being returned.

// You must implement the functions of the class such that each function works in average O(1) time complexity.

public class InsertDeleteGetRandomO1 {

	List<Integer> list;
	Map<Integer, Integer> map; // { val: index in list }

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
			list.set(index, list.get(list.size() - 1));
			map.put(list.get(list.size() - 1), index);
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
