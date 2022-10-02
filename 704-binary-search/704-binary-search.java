class Solution {
    public int search(int[] nums, int data) {
        int l=0;
        int h= nums.length-1;
        while(l<=h){
            int m = (l+h)/2;
            
            if(data>nums[m]){
                l=m+1;
            }
            else if (data<nums[m]){
                h= m-1;
            }
            else{
                return m;
            }
        }
        return -1;
    }
}