class Solution {
    public int maxLength(List<String> arr) {
        List<Integer> mask = new ArrayList<>();
        int max = 0;
        mask.add(0);
        for (String s : arr) {
            int dup = 0, cur = 0;
            for (char c : s.toCharArray()) {
                dup |= cur & (1 << (c - 'a'));
                cur |= 1 << (c - 'a');
            }
            if (dup > 0) continue;
            for (int i = 0; i < mask.size(); ++i) {
                if ((mask.get(i) & cur) > 0) continue;
                int comb = mask.get(i) | cur;
                mask.add(comb);
                max = Math.max(max, Integer.bitCount(comb));
            }
        }
        return max;
    }
}
