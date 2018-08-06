import java.util.TreeMap;

// LeetCode #846 (Hand of Straights).

// Alice has a hand of cards, given as an array of integers.

// Now she wants to rearrange the cards into groups so that each
// group is size W, and consists of W consecutive cards.

// Return true if and only if she can.

public class HandOfStraights {

	public boolean isNStraightHand(int[] hand, int W) {
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		for (int card : hand) {
			Integer count = treeMap.get(card);
			count = (count == null) ? 1 : (count + 1);
			treeMap.put(card, count);
		}
		for (Integer card : treeMap.keySet()) {
			if (treeMap.get(card) > 0) {
				for (int next = card + 1; next < card + W; next++) {
					Integer count = treeMap.get(next);
					if (count == null || count < treeMap.get(card)) {
						return false;
					}
					treeMap.put(next, count - treeMap.get(card));
				}
				treeMap.put(card, 0);
			}
		}
		return true;
	}
	
	// Time complexity is O(n*log(n)).
	// Space complexity is O(n).
}
