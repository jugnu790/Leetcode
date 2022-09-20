class Solution {
  public int findLength(int[] A, int[] B) {
    int m = A.length;
    int n = B.length;
    int[][] p = new int[m][n];
    int max = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if(A[i] == B[j]) {
          if(i == 0 || j == 0) {
            p[i][j] = 1;
          } else {
            p[i][j] = p[i - 1][j - 1] + 1;
          }
        }
        max = Math.max(p[i][j], max);
      }
    }
    return max;
  }
}