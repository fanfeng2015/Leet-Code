import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode #599 (Minimum Index Sum of Two Lists).

// Suppose Andy and Doris want to choose a restaurant for dinner, and they both have 
// a list of favorite restaurants represented by strings.

// You need to help them find out their common interest with the least list index sum. 

// If there is a choice tie between answers, output all of them with no order requirement.

// You could assume there always exists an answer.

// Note:
// 1. The length of both lists will be in the range of [1, 1000].
// 2. The length of strings in both lists will be in the range of [1, 30].
// 3. The index is starting from 0 to the list length minus 1.
// 4. No duplicates in both lists.

public class MinimumIndexSumOfTwoLists {

	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < list1.length; i++) {
			map.put(list1[i], i);
		}

		int min = Integer.MAX_VALUE;
		List<String> result = new ArrayList<>();
		for (int i = 0; i < list2.length; i++) {
			Integer index = map.get(list2[i]);
			if (index != null && i + index < min) {
				min = i + index;
				result.clear();
				result.add(list2[i]);
			} else if (index != null && i + index == min) {
				result.add(list2[i]);
			}
		}

		return result.toArray(new String[] {});
	}

	// Time complexity is O(m + n).
	// Space complexity is O(m).
}
