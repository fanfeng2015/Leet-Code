import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// LeetCode #301 (Remove Invalid Parentheses).

// Remove the minimum number of invalid parentheses in order to make the input string valid. 
// Return all possible results.

// Note: The input string may contain letters other than the parentheses ( and ).

public class RemoveInvalidParentheses {

	// Solution 1: DFS
	public List<String> removeInvalidParentheses(String s) {
		List<String> result = new ArrayList<>();
		remove(s, result, 0, 0, new char[] { '(', ')' });
		return result;
	}

	public void remove(String s, List<String> result, int previ, int prevj, char[] parentheses) {
		int count = 0;
		for (int i = previ; i < s.length(); i++) {
			if (s.charAt(i) == parentheses[0]) {
				count++;
			} else if (s.charAt(i) == parentheses[1]) {
				count--;
			}
			if (count >= 0) {
				continue;
			}
			// count < 0, the first invalid ) appears
			for (int j = prevj; j <= i; j++) {
				if (s.charAt(j) == parentheses[1] && (j == prevj || s.charAt(j - 1) != parentheses[1])) {
					// ()()), can remove the first, second or the third ), but removing the second
					// and removing the third are the same
					remove(s.substring(0, j) + s.substring(j + 1, s.length()), result, i, j, parentheses);
				}
			}
			return; // the rest has already been handled in recursion
		}
		// once this point is reached, there is no invalid ) in string s, check for any
		// invalid (
		String reversed = new StringBuilder(s).reverse().toString();
		if (parentheses[0] == '(') {
			remove(reversed, result, 0, 0, new char[] { ')', '(' });
		} else {
			result.add(reversed);
		}
	}

	// Solution 2: BFS (strings on level i have i deleted parentheses)
	public List<String> removeInvalidParentheses2(String s) {
		List<String> result = new ArrayList<>();
		Set<String> visited = new HashSet<>();
		LinkedList<String> queue = new LinkedList<>();
		visited.add(s);
		queue.offerFirst(s);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) { // need to return all possible valid strings on the current level
				String cur = queue.pollLast();
				if (isValid(cur)) {
					result.add(cur);
				}
				// once a valid string is found on the current level, no need to delete any more
				// parentheses
				if (result.size() == 0) {
					for (int j = 0; j < cur.length(); j++) {
						if (cur.charAt(j) == '(' || cur.charAt(j) == ')') { // can contain letters
							String next = cur.substring(0, j) + cur.substring(j + 1);
							if (!visited.contains(next)) {
								visited.add(next);
								queue.offerFirst(next);
							}
						}
					}
				}
			}
			if (result.size() > 0) {
				return result;
			}
		}
		return result.size() == 0 ? Arrays.asList(new String[] { "" }) : result;
	}

	private boolean isValid(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				count++;
			} else if (s.charAt(i) == ')') {
				count--;
			}
			if (count < 0) {
				return false;
			}
		}
		return count == 0;
	}

}
