class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) {
                    continue;
                } else {
                    break;
                }
            } else {
                count++;
            }
        }
        return count;
    }
}