import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

// LeetCode #381 (Insert Delete GetRandom O(1) - Duplicates Allowed).

// Design a data structure that supports all following operations in average O(1) time.

// Note: Duplicate elements are allowed.

// insert(val): Inserts an item val to the collection.
// remove(val): Removes an item val from the collection if present.
// getRandom: Returns a random element from current collection of elements. The probability
//            of each element being returned is linearly related to the number of same value the collection contains.

public class InsertDeleteGetRandomO1DuplicatesAllowed {

	List<Integer> list;
	Map<Integer, LinkedHashSet<Integer>> map;

	public InsertDeleteGetRandomO1DuplicatesAllowed() {
		list = new ArrayList<>();
		// iterator() on HashSet takes O(n), on LinkedHashSet takes O(1)
		map = new HashMap<Integer, LinkedHashSet<Integer>>();
	}

	public boolean insert(int val) {
		list.add(val);
		LinkedHashSet<Integer> indices = map.get(val);
		indices = indices == null ? new LinkedHashSet<>() : indices;
		indices.add(list.size() - 1);
		map.put(val, indices);
		return indices.size() == 1;
	}

	public boolean remove(int val) {
		LinkedHashSet<Integer> indices = map.get(val);
		if (indices == null) {
			return false;
		}
		Integer index = indices.iterator().next();
		index = (val == list.get(list.size() - 1)) ? list.size() - 1 : index; // trick
		if (index != list.size() - 1) {
			LinkedHashSet<Integer> swap = map.get(list.get(list.size() - 1));
			swap.remove(list.size() - 1);
			swap.add(index);
			list.set(index, list.get(list.size() - 1));
		}
		list.remove(list.size() - 1);
		indices.remove(index);
		if (indices.isEmpty()) {
			map.remove(val);
		}
		return true;
	}

	public int getRandom() {
		Random random = new Random();
		return list.get(random.nextInt(list.size()));
	}

}
