// LeetCode #165 (Compare Version Numbers).

// Compare two version numbers version1 and version2.

public class CompareVersionNumbers {

	public int compareVersion(String version1, String version2) {
		String[] sequence1 = version1.split("\\.");
		String[] sequence2 = version2.split("\\.");
		int length = Math.max(sequence1.length, sequence2.length);
		for (int i = 0; i < length; i++) {
			Integer num1 = i < sequence1.length ? Integer.parseInt(sequence1[i]) : 0;
			Integer num2 = i < sequence2.length ? Integer.parseInt(sequence2[i]) : 0;
			int compare = num1.compareTo(num2);
			if (compare != 0) {
				return compare;
			}
		}
		return 0;
	}

	// Time complexity is O(m + n).
	// Space complexity is O(m + n).
}
