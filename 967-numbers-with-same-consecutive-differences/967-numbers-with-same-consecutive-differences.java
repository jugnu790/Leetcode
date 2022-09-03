class Solution {
    List<Integer> ans = new ArrayList();
    public int[] numsSameConsecDiff(int N, int K) {
        for(int i = 1;i<10;i++)
            help(N,0,i,K);
        if(N==1)
            ans.add(0);
        int [] res = new int [ans.size()];
        for(int i = 0;i<ans.size();i++)
            res[i] = ans.get(i);
        return res;
    }
    private void help(int N, int number, int digit,int K)
    {
        if(N==1)
        {
            ans.add(number*10+digit);
            return;
        }
        number*=10;
        if(digit+K<10)
            help(N-1,number+digit,digit+K,K);
        if(digit-K>=0&&K!=0)
            help(N-1,number+digit,digit-K,K);
            
    }
}