// LeetCode #547 (Friend Circles).

// There are N students in a class. Some of them are friends, while some are not. 

// Their friendship is transitive in nature. For example, if A is a direct friend of B, 
// and B is a direct friend of C, then A is an indirect friend of C. And we defined a 
// friend circle is a group of students who are direct or indirect friends.

// Given a N*N matrix M representing the friend relationship between students in the class. 
// If M[i][j] = 1, then the i-th and j-th students are direct friends with each other, 
// otherwise not. And you have to output the total number of friend circles among all the
// students.

public class FriendCircles {

	public int findCircleNum(int[][] M) {
		int n = M.length;
		UnionFind unionFind = new UnionFind(n);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (M[i][j] == 1) {
					unionFind.union(i, j);
				}
			}
		}
		return unionFind.count();
	}

	// Time complexity is O(n*log(n)) where n is the input size, not the number of
	// students.
	// Space complexity is O(sqrt(n)).
}
