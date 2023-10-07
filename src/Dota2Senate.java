import java.util.LinkedList;

// LeetCode #649 (Dota2 Senate).

// https://leetcode.com/problems/dota2-senate/description/

public class Dota2Senate {

	public String predictPartyVictory(String senate) {
		int r = 0, d = 0; // number of 'R' or 'D' to be banned
		int rCount = 0, dCount = 0; // number of members of each party
		LinkedList<Character> queue = new LinkedList<>();
		for (char ch : senate.toCharArray()) {
			rCount = (ch == 'R') ? rCount + 1 : rCount;
			dCount = (ch == 'D') ? dCount + 1 : dCount;
			queue.addLast(ch);
		}
		while (rCount > 0 && dCount > 0) { // queue.size() > 0 for sure
			char ch = queue.removeFirst();
			if (ch == 'R') {
				if (r > 0) { // banned
					r--;
					rCount--;
				} else {
					d++;
					queue.addLast(ch);
				}
			} else if (ch == 'D') {
				if (d > 0) {
					d--;
					dCount--;
				} else {
					r++;
					queue.addLast(ch);
				}
			}
		}
		return rCount == 0 ? "Dire" : "Radiant";
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
