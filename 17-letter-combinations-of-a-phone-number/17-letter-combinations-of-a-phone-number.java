class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            int index = digits.charAt(i) - '2';
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < map[index].length(); j++) {
                for (String s : result) {
                    temp.add(s + map[index].charAt(j));
                }
            }
            result = temp;
        }
        return result;       
    }
}
