import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LeetCode #609 (Find Duplicate File in System).

// Given a list of directory info including directory path, and all the files with contents 
// in this directory, you need to find out all the groups of duplicate files in the file 
// system in terms of their paths.

// A group of duplicate files consists of at least two files that have exactly the same content.

// Notes:
// 1. No order is required for the final output.
// 2. You may assume the directory name, file name and file content only has letters and digits, 
//    and the length of file content is in the range of [1,50].
// 3. The number of files given is in the range of [1,20000].
// 4. You may assume no files or directories share the same name in the same directory.
// 5. You may assume each given directory info represents a unique directory. Directory path and
//    file info are separated by a single blank space.

public class FindDuplicateFileInSystem {

	public List<List<String>> findDuplicate(String[] paths) {
		Map<String, List<String>> contentToDirs = new HashMap<>();
		for (String path : paths) {
			String[] tokens = path.split(" ");
			for (int i = 1; i < tokens.length; i++) {
				int index = tokens[i].indexOf("(");
				String file = tokens[i].substring(0, index);
				String content = tokens[i].substring(index + 1, tokens[i].length() - 1);
				contentToDirs.putIfAbsent(content, new ArrayList<>());
				contentToDirs.get(content).add(tokens[0] + "/" + file);
			}
		}
		List<List<String>> result = new ArrayList<>();
		for (Map.Entry<String, List<String>> entry : contentToDirs.entrySet()) {
			if (entry.getValue().size() > 1) {
				result.add(entry.getValue());
			}
		}
		return result;
	}

	// Time complexity is O(n*k).
	// Space complexity is O(n*k).
}
