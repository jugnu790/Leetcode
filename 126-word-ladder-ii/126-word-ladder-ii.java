class Solution {
    Map<String,List<String>> map;
    List<List<String>> results;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        results = new ArrayList<>();
        if(wordList.size() ==0 || !wordList.contains(endWord)) return results;

        int min = Integer.MAX_VALUE;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        map = new HashMap<String,List<String>>();
        Map<String,Integer> ladder = new HashMap<>();  

        for(String string : wordList){
            ladder.put(string,Integer.MAX_VALUE);
        }
        ladder.put(beginWord,0);

        while(!queue.isEmpty()){
            String word = queue.poll();
            int step = ladder.get(word) + 1;
            if(step > min) 
                break;

            for(int i=0;i<word.length();i++){
                StringBuilder sb = new StringBuilder(word);
                for(char c = 'a';c<='z';c++){
                    sb.setCharAt(i,c);
                    String new_word = sb.toString();
                    if(ladder.containsKey(new_word)){
                        
                        if(step > ladder.get(new_word))
                            continue;
                        else if(step < ladder.get(new_word)){
                            queue.add(new_word);
                            ladder.put(new_word,step);
                        }
                
                        if(map.containsKey(new_word))
                            map.get(new_word).add(word);
                        else{
                            List<String> list = new LinkedList<String>();
                            list.add(word);
                            map.put(new_word,list);
                        }
                        if(new_word.equals(endWord))
                            min = step;
                    }
                }
            }

        }
        LinkedList<String> result = new LinkedList<String>();
        backTrace(endWord, beginWord, result);
        return results;
    }

    private void backTrace(String word, String start, List<String> list) {
        if (word.equals(start)) {
            list.add(0, start);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0, word);
        if (map.get(word) != null)
            for (String s : map.get(word))
                backTrace(s, start, list);
        list.remove(0);
    }
}
