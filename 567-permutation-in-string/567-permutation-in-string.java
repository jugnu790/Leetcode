class Solution {
    public boolean checkInclusion(String s1, String s2) {
       int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
        }
        int left = 0, right = 0, len = s1.length();
        while (right < s2.length()) {
            if (count[s2.charAt(right++) - 'a']-- >= 1) {
                len--;
            }
            if (len == 0) return true;
            if (right - left == s1.length() && count[s2.charAt(left++) - 'a']++ >= 0) {
                len++;
            }
        }
        return false;
    }

}