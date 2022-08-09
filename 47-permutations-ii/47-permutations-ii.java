class Solution {
    public List<List<Integer>> res;
    
    public void permutation(int cb,int tb,HashMap<Integer,Integer> map,List<Integer> asf){
        if(cb>tb){
            List<Integer> bres = new ArrayList<>();
            for(int val :asf){
                bres.add(val);
            }
            res.add(bres);
            return ;
        }
        for(int val : map.keySet()){
            if(map.get(val)>0){
                map.put(val,map.get(val)-1);
                asf.add(val);
                permutation(cb+1,tb,map,asf);
                asf.remove(asf.size()-1);
                map.put(val,map.get(val)+1);
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int val : nums){
            map.put(val,map.getOrDefault(val,0)+1);
            
        }
        List<Integer>asf = new ArrayList<>();
        permutation(1,nums.length,map,asf);
        return res;
        
    }
}