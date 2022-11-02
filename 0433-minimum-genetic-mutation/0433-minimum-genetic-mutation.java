class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        Set<String> bankSet = new HashSet<>();
        for (String s : bank) {
            bankSet.add(s);
        }
        if (!bankSet.contains(end)) {
            return -1;
        }
        char[] gene = new char[]{'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(end)) {
                    return step;
                }
                char[] curArray = cur.toCharArray();
                for (int j = 0; j < curArray.length; j++) {
                    char old = curArray[j];
                    for (char c : gene) {
                        curArray[j] = c;
                        String newString = new String(curArray);
                        if (bankSet.contains(newString)) {
                            queue.offer(newString);
                            bankSet.remove(newString);
                        }
                    }
                    curArray[j] = old;
                }
            }
            step++;
        }
        return -1;
    }
}