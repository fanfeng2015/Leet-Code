// LeetCode #38 (Count and Say).

// The count-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, ...

public class CountAndSay {

	public String countAndSay(int n) {
		StringBuilder sb = new StringBuilder("1");
		for (int i = 1; i < n; i++) {
			String s = sb.toString();
			sb.delete(0, sb.length());
			int start = 0, cur = 0;
			while (cur < s.length()) {
				while (cur < s.length() && s.charAt(cur) == s.charAt(start)) {
					cur++;
				}
				sb.append(cur - start).append(s.charAt(start));
				start = cur;
			}
		}
		return sb.toString();
	}

	// Complexity depends on f(n), i.e., the length of the n-th sequence.
}
