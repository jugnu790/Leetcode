class Solution {
    public int[] sortedSquares(int[] nums) {
        int n= nums.length;
        int [] res = new int[n];
        for(int k=0 ;k<nums.length;k++){
            res[k] = nums[k]*nums[k];
                //return res;
                //Arrays.sort(res);
                //return res;
        }
         Arrays.sort(res);
         return res;
    }
}