import java.util.HashMap;

// LeetCode #464 (Can I Win).

// In the "100 game," two players take turns adding, to a running total, any integer from 1..10. 
// The player who first causes the running total to reach or exceed 100 wins.

// What if we change the game so that players cannot re-use integers?

// For example, two players might take turns drawing from a common pool of numbers of 1..15 without
// replacement until they reach a total >= 100.

// Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player
// to move can force a win, assuming both players play optimally.

// You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not
// be larger than 300.

public class CanIWin {

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if (desiredTotal <= 0) {
			return true;
		}
		if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
			return false;
		}
		return canIWin(maxChoosableInteger, desiredTotal, 0, new HashMap<Integer, Boolean>());
	}

	private boolean canIWin(int maxChoosableInteger, int desiredTotal, int used, HashMap<Integer, Boolean> map) {
		if (map.containsKey(used)) {
			return map.get(used);
		}
		for (int i = 0; i < maxChoosableInteger; i++) {
			if ((used & (1 << i)) != 0) {
				continue;
			}
			// can pick number i + 1
			if (desiredTotal <= i + 1 || !canIWin(maxChoosableInteger, desiredTotal - (i + 1), used ^ (1 << i), map)) {
				map.put(used, true);
				return true;
			}
		}
		map.put(used, false);
		return false;
	}

	// Let n be maxChoosableInteger.
	// Time complexity is O(2^n).
	// Space complexity is O(2^n).
}