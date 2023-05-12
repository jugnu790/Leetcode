class Solution {
  public long mostPoints(int[][] questions) {
    var n = questions.length;
    var dp = new long[n];
    dp[n-1] = questions[n-1][0];

    for (var i = n-2; i >= 0; i--) {
      var nextQ = i + questions[i][1] + 1;
      
      dp[i] = Math.max(
                questions[i][0] + (nextQ < n ? dp[nextQ] : 0),
                dp[i+1]);
    }
    return dp[0];
  }
}