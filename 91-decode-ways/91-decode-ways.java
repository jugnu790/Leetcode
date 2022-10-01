class Solution {
    public int numDecodings(String s) {
        int a = 1, len = s.length();
        int b = s.charAt(0) == '0' ? 0 : 1, ans = b;
           
        for (int i = 2; i <= len; ++i) {
            ans = 0;
            
            if (s.charAt(i - 1) != '0') {
                ans += b;     
            }
            
            int two_pre = Integer.valueOf(s.substring(i-2, i));
            
            if(two_pre >= 10 && two_pre <= 26) {
                ans += a;
            }
            
            a = b;
            b = ans;
        }
        return ans;
    }
}