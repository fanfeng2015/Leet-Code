import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// LeetCode #721 (Accounts Merge).

// Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and
// the rest of the elements are emails representing emails of the account.

// Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both
// accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. 
// A person can have any number of accounts initially, but all of their accounts definitely have the same name.

// After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest
// of the elements are emails in sorted order. The accounts themselves can be returned in any order.

public class AccountsMerge {

	// [ John: [a, b, f], [John: c], [John: a, d], [Mary: e] ]
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		Map<String, String> owners = new HashMap<>(); // { email: name }
		// { a: [a, b, f, d], b: [a], f: [a], c: [c], d: [a], e: [e] }
		Map<String, HashSet<String>> graph = new HashMap<>();
		// build owners and graph
		for (List<String> list : accounts) {
			for (int i = 1; i < list.size(); i++) {
				owners.put(list.get(i), list.get(0));
				if (!graph.containsKey(list.get(i))) {
					graph.put(list.get(i), new HashSet<String>());
				}
				graph.get(list.get(1)).add(list.get(i));
				graph.get(list.get(i)).add(list.get(1));
			}
		}
		// find connected components
		List<List<String>> result = new ArrayList<List<String>>();
		Set<String> visited = new HashSet<>();
		LinkedList<String> queue = new LinkedList<>();
		for (String email : graph.keySet()) {
			if (visited.add(email)) { // a new group
				queue.offerFirst(email);
				List<String> group = new LinkedList<String>(); // O(1) time for add(0, ...)
				while (!queue.isEmpty()) {
					String cur = queue.pollLast();
					group.add(cur);
					for (String neighbor : graph.get(cur)) {
						if (visited.add(neighbor)) {
							queue.offerFirst(neighbor);
						}
					}
				}
				Collections.sort(group);
				group.add(0, owners.get(email));
				result.add(group);
			}
		}
		return result;
	}

	// Time complexity is O(n*log(n)), because of sorting.
	// Space complexity is O(n).
}
