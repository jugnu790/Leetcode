class Solution {
   public int minCost(String s, int[] cost) {
        int n = s.length();
        int ans = 0;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            int max = cost[i];
            int sum = cost[i];
            while (j < n && s.charAt(j) == s.charAt(i)) {
                max = Math.max(max, cost[j]);
                sum += cost[j];
                j++;
            }
            ans += sum - max;
            i = j;
        }
        return ans;
    }
}