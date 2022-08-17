class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] str = ".-,-...,-.-.,-..,.,..-.,--.,....,..,.---,-.-,.-..,--,-.,---,.--.,--.-,.-.,...,-,..-,...-,.--,-..-,-.--,--..".split(",");
        
        Set<String> set = new HashSet<>();
        for (int i=0;i<words.length;i++){
            
            String temp = words[i];
            String answer="";
            for (int j=0;j<temp.length();j++){
                answer=answer + str[temp.charAt(j)-'a'];                                                
            }
            set.add(answer);
                        
        }
        return set.size();
    }
}