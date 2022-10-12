class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        helper(s.toCharArray(), 0, result);
        return result;
    }

    private void helper(char[] charArray, int i, List<String> result) {
        if (i == charArray.length) {
            result.add(new String(charArray));
            return;
        }
        if (Character.isDigit(charArray[i])) {
            helper(charArray, i + 1, result);
        } else {
            charArray[i] = Character.toLowerCase(charArray[i]);
            helper(charArray, i + 1, result);
            charArray[i] = Character.toUpperCase(charArray[i]);
            helper(charArray, i + 1, result);
        }
    }
}   