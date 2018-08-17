import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

// LeetCode #465 (Optimal Account Balancing).

// A group of friends went on holiday and sometimes lent each other money. 

// For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a
// taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave
// person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1,
// 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].

// Given a list of transactions between a group of people, return the minimum number of 
// transactions required to settle the debt.

// Notes:
// 1. A transaction will be given as a tuple (x, y, z). Note that x != y and z > 0.
// 2. Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could 
//    also have the persons 0, 2, 6.

public class OptimalAccountBalancing {

	public int minTransfers(int[][] transactions) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int[] transaction : transactions) {
			map.putIfAbsent(transaction[0], 0);
			map.putIfAbsent(transaction[1], 0);
			map.put(transaction[0], map.get(transaction[0]) + transaction[2]);
			map.put(transaction[1], map.get(transaction[1]) - transaction[2]);
		}
		List<Integer> balance = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() != 0) {
				balance.add(entry.getValue());
			}
		}
		return DFS(balance, 0);
	}

	private int DFS(List<Integer> balance, int cur) {
		int min = Integer.MAX_VALUE;
		while (cur < balance.size() && balance.get(cur) == 0) {
			cur++;
		}
		for (int i = cur + 1; i < balance.size(); i++) {
			if (balance.get(cur) * balance.get(i) < 0) {
				balance.set(i, balance.get(i) + balance.get(cur));
				min = Math.min(min, 1 + DFS(balance, cur + 1));
				balance.set(i, balance.get(i) - balance.get(cur));
			}
		}
		return (min == Integer.MAX_VALUE) ? 0 : min;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
