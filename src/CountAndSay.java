// LeetCode #38 (Count and Say).

// The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
// 1. countAndSay(1) = "1"
// 2. countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different
//    digit string.

// To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains 
// exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every 
// said digit.

// 1, 11, 21, 1211, 111221, ...

public class CountAndSay {

	public String countAndSay(int n) {
		String prev = "1", next = "";
		for (int i = 1; i < n; i++) {
			next = countAndSay(prev);
			prev = next;
		}
		return prev;
	}

	private String countAndSay(String s) {
		StringBuilder sb = new StringBuilder();
		int slow = 0, fast = 0;
		while (fast < s.length()) {
			if (s.charAt(fast) != s.charAt(slow)) {
				sb.append(fast - slow).append(s.charAt(slow));
				slow = fast;
			}
			fast++;
		}
		sb.append(fast - slow).append(s.charAt(slow));
		return sb.toString();
	}

	// Time complexity is O(4^(n/3)).
	// Space complexity is O(4^(n/3)).
}
