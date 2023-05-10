class Solution {
	public int[][] generateMatrix(int n) {
		// define matrix
		int[][] res = new int[n][n];

		// define pointers
		int top = 0, bottom = n - 1;
		int left = 0, right = n - 1;
		int val = 1;

		// run loop until n
		while(val <= n*n){

			// run till right(traverse all positions of top row by moving right till right) and cut top row by incrementing
			for(int i = left; i <= right; i++)
				res[top][i] = val++;

			top++;

			// run till bottom(traverse all positions of right column by moving down till bottom) and cut right column by decrementing
			for(int i = top; i <= bottom; i++)
				res[i][right] = val++;

			right--;

			// run till left(traverse all positions of bottom row by moving left till left) and cut bottom row by decrementing
			for(int i = right; i >= left; i--)
				res[bottom][i] = val++;

			bottom--;

			// run till top(traverse all positions of left column by moving till top) and cut left column by incrementing
			for(int i = bottom; i >= top; i--)
				res[i][left] = val++;

			left++;

		}

		// return created matrix
		return res;
	}
}