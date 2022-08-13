
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s.length() == 0 || words.length == 0) return res;
        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        for(int i = 0; i < s.length() - totalLen + 1; i++) {
            String cur = s.substring(i, i + totalLen);
            if(isValid(cur, words, wordLen)) res.add(i);
        }
        return res;
    }
    private boolean isValid(String cur, String[] words, int wordLen) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        Map<String, Integer> curMap = new HashMap<>();
        for(int i = 0; i < cur.length(); i += wordLen) {
            String word = cur.substring(i, i + wordLen);
            if(!map.containsKey(word)) return false;
            curMap.put(word, curMap.getOrDefault(word, 0) + 1);
            if(curMap.get(word) > map.get(word)) return false;
        }
        return true;
    }
}