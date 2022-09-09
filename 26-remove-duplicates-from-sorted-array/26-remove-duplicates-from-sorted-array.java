class Solution {
   
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int match = 0;
        
        for(int i=1;i<nums.length;i++){
            
            if(nums[i]==nums[i-1]){
                match=match+1;
                nums = leftshiftByOne(nums, i);
                i--;
            }
            if(count == nums.length-1){
               break;
            }
            count=count+1;
        }
        
         return  count-match+1;
    }
    
    private int[] leftshiftByOne(int[] nums, int start){
        for(int i=start;i<nums.length-1;i++){
            nums[i]=nums[i+1];
        }
        
        return nums;
    }
}