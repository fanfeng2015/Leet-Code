// LeetCode #277 (Find The Celebrity).

// Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there
// may exist one celebrity. The definition of a celebrity is that all the other n - 1 people
// know him/her but he/she does not know any of them.

// Now you want to find out who the celebrity is or verify that there is not one.

// The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to
// get information of whether A knows B. You need to find out the celebrity (or verify there
// is not one) by asking as few questions as possible (in the asymptotic sense).

// You are given a helper function boolean knows(a, b), which tells you whether A knows B. 
// Implement a function int findCelebrity(n), your function should minimize the number of calls
// to knows.

// There will be exactly one celebrity if he/she is in the party. 
// Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, 
// return -1.

public class FindTheCelebrity extends Relation {

	public int findCelebrity(int n) {
		int candidate = 0;
		for (int i = 0; i < n; i++) {
			// if candidate knows i, candidate is not a celebrity for sure
			// if candidate doesn't know i, then i is not a celebrity for sure
			if (knows(candidate, i)) {
				candidate = i;
			}
		}
		for (int i = 0; i < n; i++) {
			if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
				return -1;
			}
		}
		return candidate;
	}

	// Time complexity is O(n).
	// Space complexity is O(1).

}

abstract class Relation {

	public boolean knows(int a, int b) {
		return true;
	}

}
