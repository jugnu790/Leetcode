class Solution {
    public int maxLength(List<String> arr) {
       int[] dp = new int[1];
        for (String s : arr) {
            int mask = 0, dup = 0;
            for (char c : s.toCharArray()) {
                dup |= mask & 1 << c - 'a';
                mask |= 1 << c - 'a';
            }
            if (dup > 0) continue;
            for (int i = dp.length - 1; i >= 0; --i) {
                if ((dp[i] & mask) == 0) {
                    dp = Arrays.copyOf(dp, dp.length + 1);
                    dp[dp.length - 1] = dp[i] | mask;
                }
            }
        }
        int res = 0;
        for (int x : dp) res = Math.max(res, Integer.bitCount(x));
        return res;
    }
}