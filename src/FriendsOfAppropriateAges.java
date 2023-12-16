// LeetCode #825 (Friends of Appropriate Ages).

// There are n persons on a social media website. You are given an integer array ages where ages[i] is the age of the ith person.

// A Person x will not send a friend request to a person y (x != y) if any of the following conditions is true:
// - age[y] <= 0.5 * age[x] + 7
// - age[y] > age[x]
// - age[y] > 100 && age[x] < 100

// Otherwise, x will send a friend request to y.

// Note that if x sends a request to y, y will not necessarily send a request to x. Also, a person will not send a friend request to
// themself.

// Return the total number of friend requests made.

public class FriendsOfAppropriateAges {

	private static final int MAX_AGE = 120;

	// B has to be in (0.5 * A + 7, A], for 0.5 * A + 7 < A, A > 14
	public int numFriendRequests(int[] ages) {
		int result = 0;
		int[] ageCount = new int[MAX_AGE + 1], prefixSum = new int[MAX_AGE + 1];
		for (int i = 0; i < ages.length; i++) {
			ageCount[ages[i]]++;
		}
		for (int i = 1; i <= MAX_AGE; i++) {
			prefixSum[i] = prefixSum[i - 1] + ageCount[i];
		}
		for (int i = 15; i <= MAX_AGE; i++) {
			if (ageCount[i] == 0) {
				continue;
			}
			int count = prefixSum[i] - prefixSum[i / 2 + 7] - 1; // not friend request oneself
			result += count * ageCount[i];
		}
		return result;
	}

	// Time complexity is O(n).
	// Space complexity is O(1), because MAX_AGE = 120.
}
