class Solution {
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int left = 0, right = 0, minLeft = 0, minLen = Integer.MAX_VALUE, counter = t.length();

        while (right < s.length()) {
            char c = s.charAt(right);
            if (map[c] > 0) {
                counter--;
            }
            map[c]--;
            right++;

            while (counter == 0) {
                if (right - left < minLen) {
                    minLeft = left;
                    minLen = right - left;
                }
                char c2 = s.charAt(left);
                map[c2]++;
                if (map[c2] > 0) {
                    counter++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}