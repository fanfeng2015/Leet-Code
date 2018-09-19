import java.util.HashMap;
import java.util.LinkedHashSet;

// LeetCode #460 (LFU Cache).

// Design and implement a data structure for Least Frequently Used (LFU) cache. 

// It should support the following operations:

// 1. get(key): get the value (will always be positive) of the key if the key exists in the cache,
//    otherwise return -1; 
// 2. put(key,value): set or insert the value if the key is not already present. When the cache 
//    reaches its capacity, it should invalidate the least frequently used item before inserting a
//    new item.

// For the purpose of this problem, when there is a tie (i.e., two or more keys have the same 
// frequency), the least recently used key would be evicted.

public class LFUCache {

	// Node of a double linked list.
	private class Node {
		int count = 0;
		LinkedHashSet<Integer> keys = null; // all keys with the same count
		Node prev = null, next = null;

		public Node(int count) {
			this.count = count;
			keys = new LinkedHashSet<>();
			prev = next = null;
		}
	}

	private Node head; // head of a doubly linked list
	private int capacity;
	private HashMap<Integer, Integer> valueMap;
	private HashMap<Integer, Node> nodeMap;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		valueMap = new HashMap<>();
		nodeMap = new HashMap<>();
	}

	public int get(int key) {
		Integer value = valueMap.get(key);
		if (value != null) {
			increaseCount(key);
			return value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (capacity == 0) {
			return;
		}
		if (valueMap.containsKey(key)) {
			valueMap.put(key, value);
		} else {
			if (valueMap.size() == capacity) {
				evict();
			}
			valueMap.put(key, value);
			addToHead(key);
		}
		increaseCount(key);
	}

	private void increaseCount(int key) {
		Node node = nodeMap.get(key);
		node.keys.remove(key);
		if (node.next == null) {
			node.next = new Node(node.count + 1);
			node.next.prev = node;
			node.next.keys.add(key);
		} else if (node.next.count == node.count + 1) {
			node.next.keys.add(key);
		} else {
			Node newNode = new Node(node.count + 1);
			newNode.keys.add(key);
			newNode.next = node.next;
			node.next.prev = newNode;
			node.next = newNode;
			newNode.prev = node;
		}
		nodeMap.put(key, node.next);
		if (node.keys.size() == 0) {
			remove(node);
		}
	}

	
	private void remove(Node node) {
		if (node.prev == null) {
			head = node.next;
		} else {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}
	}

	private void evict() {
		if (head == null) {
			return;
		}
		int evict = head.keys.iterator().next();
		head.keys.remove(evict);
		if (head.keys.size() == 0) {
			remove(head);
		}
		valueMap.remove(evict);
		nodeMap.remove(evict);
	}

	private void addToHead(int key) {
		if (head == null) {
			head = new Node(0);
			head.keys.add(key);
		} else if (head.count > 0) {
			Node node = new Node(0);
			node.keys.add(key);
			node.next = head;
			head.prev = node;
			head = node;
		} else {
			head.keys.add(key);
		}
		nodeMap.put(key, head);
	}

}
