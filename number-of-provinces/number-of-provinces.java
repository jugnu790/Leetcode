class Solution {
  private void dfs(int city, int[][] isConnected, boolean[] seen) {
    seen[city] = true;

    for (var i = 0; i < isConnected.length; i++)
      if (isConnected[city][i] == 1 && !seen[i])
        dfs(i, isConnected, seen);
  }

  public int findCircleNum(int[][] isConnected) {
    var n = isConnected.length;
    var seen = new boolean[n];
    var cnt = 0;

    for (var i=0; i<n; i++) {
      if (!seen[i]) {
        dfs(i, isConnected, seen);
        cnt++;
      }
    }
    return cnt;
  }
}