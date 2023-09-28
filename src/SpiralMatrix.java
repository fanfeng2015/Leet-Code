import java.util.ArrayList;
import java.util.List;

// LeetCode #54 (Spiral Matrix).

// Given an m x n matrix, return all elements of the matrix in spiral order.

public class SpiralMatrix {
	
	  public List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> result = new ArrayList<>();
	        int m = matrix.length, n = matrix[0].length;
	        int top = 0, bottom = m - 1, left = 0, right = n - 1;
	        while (top < bottom && left < right) {
	            for (int i = left; i < right; i++) {
	                result.add(matrix[top][i]);
	            }
	            for (int i = top; i < bottom; i++) {
	                result.add(matrix[i][right]);
	            }
	            for (int i = right; i > left; i--) {
	                result.add(matrix[bottom][i]);
	            }
	            for (int i = bottom; i > top; i--) {
	                result.add(matrix[i][left]);
	            }
	            top++;
	            bottom--;
	            left++;
	            right--;
	        }
	        // top >= bottom || left >= right
	        if (top == bottom) {  // there is a row
	            for (int i = left; i <= right; i++) {
	                result.add(matrix[top][i]);
	            }
	        } else if (left == right) {  // there is a column
	            for (int i = top; i <= bottom; i++) {
	                result.add(matrix[i][left]);
	            }
	        }
	        return result;
	    }
	  
		// Time complexity is O(m*n).
		// Space complexity is O(1).	  
}
