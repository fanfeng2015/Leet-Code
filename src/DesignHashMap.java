import java.util.ArrayList;

// LeetCode #706 (Design HashMap).

// Design a HashMap without using any built-in hash table libraries.

// Implement the MyHashMap class:

// - MyHashMap() initializes the object with an empty map.
// - void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, 
//   update the corresponding value.
// - int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for
//   the key.
// - void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.

public class DesignHashMap {

	private class Pair {
		int key;
		int value;

		Pair(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private int SIZE = 1000;
	private ArrayList<Pair>[] lists;

	@SuppressWarnings("unchecked")
	public DesignHashMap() {
		this.lists = new ArrayList[SIZE];
	}

	public void put(int key, int value) {
		if (lists[key % SIZE] == null) {
			lists[key % SIZE] = new ArrayList<Pair>();
		}
		for (Pair pair : lists[key % SIZE]) {
			if (pair.key == key) {
				pair.value = value;
				return;
			}
		}
		lists[key % SIZE].add(new Pair(key, value));
	}

	// Time complexity is O(n/k), where n is total number of possible values, and k
	// is number of buckets.
	// Space complexity is O(k+m), where m is the number of unique keys.

	public int get(int key) {
		if (lists[key % SIZE] == null) {
			return -1;
		}
		for (Pair pair : lists[key % SIZE]) {
			if (pair.key == key) {
				return pair.value;
			}
		}
		return -1;
	}

	// Time complexity is O(n/k), where n is total number of possible values, and k
	// is number of buckets.
	// Space complexity is O(k+m), where m is the number of unique keys.

	public void remove(int key) {
		if (lists[key % SIZE] == null) {
			return;
		}
		for (int i = 0; i < lists[key % SIZE].size(); i++) {
			if (lists[key % SIZE].get(i).key == key) { // get() is O(1) time
				lists[key % SIZE].remove(i); // remove() is O(n) time
				return;
			}
		}
	}

	// Time complexity is O(n/k), where n is total number of possible values, and k
	// is number of buckets.
	// Space complexity is O(k+m), where m is the number of unique keys.
}
