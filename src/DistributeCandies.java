import java.util.HashSet;
import java.util.Set;

// LeetCode #575 (Distribute Candies).

// Given an integer array with even length, where different numbers in this array represent 
// different kinds of candies. Each number means one candy of the corresponding kind. 

// You need to distribute these candies equally in number to brother and sister. Return the
// maximum number of kinds of candies the sister could gain.

public class DistributeCandies {

	public int distributeCandies(int[] candies) {
		Set<Integer> kinds = new HashSet<Integer>();
		for (int i = 0; i < candies.length; i++) {
			kinds.add(candies[i]);
		}
		return 2 * kinds.size() <= candies.length ? kinds.size() : candies.length / 2;
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
