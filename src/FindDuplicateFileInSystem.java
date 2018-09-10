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

	// Follow up:

	// 1. Imagine you are given a real file system, how will you search files?
	// Answer: DFS if file system is not too deep. BFS if branching factor is not
	// too large.

	// 2. If the file content is very large (GB), how will you modify your solution?
	// Answer: Use metadata, { file size: file content }. Then we only need to hash
	// the file content when there are more than one file with the same size.

	// 3. If you can only read the file by 1KB each time, how will you modify your
	// solution?
	// Answer: a. Increase heap size if possible. b. Change buffer size to 1KB to
	// make memory more efficient.

	// 4. What is the time complexity of your modified solution? What is the most
	// time-consuming part and memory consuming part of it? How to optimize?
	// Answer: Hashing. Instead of hashing, use checksum in GFS. GFS stores large
	// files in chunks. Each chunk has meta data including file name, file size,
	// index and checksum of each chunk, etc. This introduces false positive since
	// two different chunks can have the same checksum.

	// 5. How to make sure the duplicated files you find are not false positive?
	// Answer: Check the files chunk by chunk.
}
