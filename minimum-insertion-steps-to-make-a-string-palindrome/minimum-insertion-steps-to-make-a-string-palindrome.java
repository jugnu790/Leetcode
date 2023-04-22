class Solution {
        public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String rev = sb.toString();
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                int val = -1;
                if(s.charAt(i-1) == rev.charAt(j-1)) {
                    val = 1 + dp[i-1][j-1];
                }
                else {
                    val =  Math.max(dp[i-1][j], dp[i][j-1]);
                }
                dp[i][j] = val;
            }
        }
        int lcsCount = dp[n][n];
       
        int minInsertion = n - lcsCount; 
        return minInsertion;
    }
}