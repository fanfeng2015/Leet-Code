import java.util.ArrayList;
import java.util.List;

// LeetCode #722 (Remove Comments).

public class RemoveComments {

	public List<String> removeComments(String[] source) {
		boolean inBlock = false;
		StringBuilder cur = new StringBuilder();
		List<String> result = new ArrayList<>();
		for (int i = 0; i < source.length; i++) {
			String str = source[i];
			int j = 0;
			while (j < str.length()) {
				if (inBlock) {
					if (j < str.length() - 1 && str.substring(j, j + 2).equals("*/")) {
						inBlock = false;
						j += 2;
					} else {
						j++;
					}
				} else {
					if (j < str.length() - 1 && str.substring(j, j + 2).equals("//")) {
						break;
					} else if (j < str.length() - 1 && str.substring(j, j + 2).equals("/*")) {
						inBlock = true;
						j += 2;
					} else {
						cur.append(str.charAt(j));
						j++;
					}
				}
			}
			if (cur.length() > 0 && !inBlock) {
				result.add(cur.toString());
				cur.setLength(0);
				cur.trimToSize();
			}
		}
		return result;
	}

	// Time complexity is O(n*k).
	// Space complexity is O(k), ignoring space needed for output.
}
