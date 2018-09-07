// LeetCode #825 (Friends of Appropriate Ages).

// Some people will make friend requests. The list of their ages is given and ages[i] is
// the age of the i-th person. 

// Person A will NOT friend request person B (B != A) if any of the following conditions
// are true:

// age[B] <= 0.5 * age[A] + 7
// age[B] > age[A]
// age[B] > 100 && age[A] < 100

// Otherwise, A will friend request B.

// Note that if A requests B, B does not necessarily request A.  Also, people will not 
// friend request themselves.

// wHow many total friend requests are made?

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
	// Space complexity is O(1).
}

