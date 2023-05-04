class Solution {
    public String predictPartyVictory(String senate) {
        int Rnumber = 0; // Radiant number
        int Dnumber = 0; // Dire number
        int curBanR = 0;// current Radiant ban
        int curBanD = 0;// current Dire ban
        int totalBanR = 0; // total Radiant ban
        int totalBanD = 0; // total Dire ban
        char[] chars = senate.toCharArray();
        boolean flag = true;
        while(true){
            for(int i = 0;i < chars.length;i++){
                char cur = chars[i];
                if(cur == 'R'){
                    if(flag)
                        Rnumber++;
                    if(curBanR == 0){
                        curBanD++;
                        totalBanD++;
                        if(totalBanD == Dnumber  && !flag)return "Radiant";
                    }else{
                        curBanR--;
                        chars[i] = 'r';
                    }
                }else if(cur == 'D'){
                    if(flag)
                        Dnumber++;
                    if(curBanD == 0){
                        curBanR++;
                        totalBanR++;
                        if(totalBanR == Rnumber  && !flag)return "Dire";
                    }else{
                        curBanD--;
                        chars[i] = 'd';
                    }
                }
            }
            flag = false;
            if(totalBanD >= Dnumber)return "Radiant";
            if(totalBanR >= Rnumber)return "Dire";
        }
    }
}