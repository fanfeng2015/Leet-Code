import java.util.LinkedList;

// LeetCode #1209 (Remove All Adjacent Duplicates in String II).

// You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and
// removing them, causing the left and the right side of the deleted substring to concatenate together.

// We repeatedly make k duplicate removals on s until we no longer can.

// Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

public class RemoveAllAdjacentDuplicatesInString2 {

	public String removeDuplicates(String s, int k) {
		LinkedList<Character> list1 = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			if (list1.isEmpty() || s.charAt(i) != list1.peekLast()) {
				list1.offerLast(s.charAt(i));
				list2.offerLast(1);
			} else {
				list2.offerLast(list2.pollLast() + 1);
				if (list2.peekLast() == k) {
					list1.pollLast();
					list2.pollLast();
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!list1.isEmpty()) {
			Character ch = list1.pollFirst();
			Integer count = list2.pollFirst();
			for (int i = 0; i < count; i++) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	// Time complexity is O(n).
	// Space complexity is O(n).
}
