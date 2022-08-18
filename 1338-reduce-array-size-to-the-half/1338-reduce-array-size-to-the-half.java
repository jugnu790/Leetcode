class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> a = new HashMap<Integer,Integer>();
        int res=0,sum=0;int count=0,sum1=0;
        for(int i:arr){
            if(a.containsKey(i)){
                a.put(i,a.get(i)+1);
            }
            else
                a.put(i,1);   
            }
        for (int f : a.values()) {
             sum += f;
          }
        ArrayList<Integer> sortedValues
            = new ArrayList<Integer>(a.values());
 
        Collections.sort(sortedValues);
        for(int i=sortedValues.size()-1;i>=0;i--){
            sum1+=sortedValues.get(i);
            res=sum-sum1;
            if(res<=arr.length/2){
                count++;
                break;
            }
            else
                count++;
        }
        return count;
    }
}
