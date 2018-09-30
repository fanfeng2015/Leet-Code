import java.util.HashMap;
import java.util.Map;

// LeetCode #146 (LRU Cache).

// Implement a least recently used cache. It should provide set(), get() operations.

// If not exists, return null.

public class LRUCache {

	private static class Node {
		Node prev;
		Node next;
		int key;
		int value;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

		void update(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private final int CAPACITY;
	private Node head;
	private Node tail;
	private Map<Integer, Node> map;

	public LRUCache(int capacity) {
		this.CAPACITY = capacity;
		this.map = new HashMap<Integer, Node>();
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node == null) {
			return -1;
		}
		remove(node);
		append(node);
		return node.value;
	}

	public void put(int key, int value) {
		Node node = null;
		if (map.containsKey(key)) {
			node = map.get(key);
			node.value = value;
			remove(node);
		} else if (map.size() < CAPACITY) {
			node = new Node(key, value);
		} else {
			node = tail;
			remove(node);
			node.update(key, value);
		}
		append(node);
	}

	// removes node from doubly linked list
	private Node remove(Node node) {
		map.remove(node.key);
		// remove node
		if (node.prev != null) {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}
		// might need to update head or tail
		if (node == head) {
			head = head.next;
		}
		if (node == tail) {
			tail = tail.prev;
		}
		node.next = node.prev = null;
		return node;
	}

	// appends node at the beginning of doubly linked list
	private Node append(Node node) {
		map.put(node.key, node);
		if (head == null) {
			head = tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
		return node;
	}

}