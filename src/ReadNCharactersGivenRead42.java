// LeetCode #158 (Read N Characters Given Read4 II - Call multiple times).

// The API: int read4(char *buf) reads 4 characters at a time from a file.

// The return value is the actual number of characters read. For example, 
// it returns 3 if there is only 3 characters left in the file.

// By using the read4 API, implement the function int read(char *buf, int n) 
// that reads n characters from the file.

// Note: The read function may be called multiple times.

public class ReadNCharactersGivenRead42 extends Reader4 {

	char[] curBuf = new char[4];
	int curIndex = 0;
	int read4Count = 0;

	public int read(char[] buf, int n) {
		int total = 0;
		while (total < n && (curIndex < read4Count || (curIndex = 0) < (read4Count = read4(curBuf)))) {
			buf[total++] = curBuf[curIndex++];
		}
		return total;
	}

}
