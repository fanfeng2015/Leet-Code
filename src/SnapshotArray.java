import java.util.TreeMap;

// LeetCode #1146 (Snapshot Array).

// Implement a SnapshotArray that supports the following interface:

// SnapshotArray(int length) initializes an array-like data structure with the given length. Initially, each element equals 0.

// - void set(index, val) sets the element at the given index to be equal to val.
// - int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
// - int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id

public class SnapshotArray {

	int snap_id = 0;
	// the i-th TreeMap records values for index i
	// each TreeMap contains { snap_id: value }
	TreeMap<Integer, Integer>[] maps;

	public SnapshotArray(int length) {
		maps = new TreeMap[length];
		for (int i = 0; i < length; i++) {
			maps[i] = new TreeMap<>();
			maps[i].put(0, 0); // initially, each element equals 0
		}
	}

	public void set(int index, int val) {
		maps[index].put(snap_id, val);
	}

	public int snap() {
		return snap_id++;
	}

	// possible that snap_id doesn't exist, e.g., value is set at t1, snapshots are
	// taken at t2, t3, ...
	public int get(int index, int snap_id) {
		return maps[index].floorEntry(snap_id).getValue();
	}

	// Time complexity is O(log(s)) for set()/get(), where s is the number of
	// snapshots.
	// Space complexity is O(#set()), where #set() is the number of set()
	// operations.
}
