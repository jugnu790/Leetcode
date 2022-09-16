class Solution {
    Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
    
    public int maximumScore(int[] nums, int[] multipliers) {
        int l = 0, r = nums.length-1;
        int score = 0;
        
        return dfs(nums, multipliers, l ,r, 0);
    }  
    
    int dfs(int[] nums, int[] multipliers, int l, int r, int k) {
        if(k >= multipliers.length) return 0;
        if(cache.containsKey(l) && cache.get(l).containsKey(r)) return cache.get(l).get(r);
              
        int res = Math.max(
            multipliers[k] * nums[l] + dfs(nums, multipliers, l + 1, r, k+1),
            multipliers[k] * nums[r] + dfs(nums, multipliers, l, r - 1, k+1)
        );
        if(!cache.containsKey(l)) cache.put(l, new HashMap<>());
        cache.get(l).put(r, res);
        return res;
    }
    
}
