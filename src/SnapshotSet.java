import java.util.HashSet;
import java.util.Iterator;

// Databricks SnapshotSet.

// Create a class that has methods add(), remove(), contains(), iterator() like a regular set, but allows for 
// modifying the set while it is being iterated. The iterator should contain the elements when it is called.

public class SnapshotSet {

	// ------------------------------
	// Solution 1:

	// When iterator() is called, copy the current elements to a new set.
	// Iterate on the new set, and add/remove/contains on the old set.

	// Problem: It consumes double the space needed for storing the values.

	// ------------------------------
	// Solution 2:

	// Use the regular set for iterator(), and keep a diff set for
	// add/remove/contains.
	// When iterator() is called, commit the diff set to the regular set.

	private HashSet<Integer> adds = new HashSet<Integer>();
	private HashSet<Integer> removes = new HashSet<Integer>();
	private HashSet<Integer> snapshot = new HashSet<Integer>();

	public boolean add(int i) {
		removes.remove(i);
		return adds.add(i); // if previously added, return false
	}

	public boolean remove(int i) {
		adds.remove(i);
		return removes.add(i); // if previously removed, return false
	}

	// semantics: does not look at the snapshot, looks at the current version of the
	// set.
	public boolean contains(int i) {
		return (snapshot.contains(i) && !removes.contains(i)) || (!snapshot.contains(i) && adds.contains(i));
	}

	// triggers the snapshot
	public Iterator<Integer> iterator() {
		for (Integer i : adds) {
			snapshot.add(i);
		}
		for (Integer i : removes) {
			snapshot.remove(i);
		}
		adds.clear();
		removes.clear();
		return snapshot.iterator();
	}

}
