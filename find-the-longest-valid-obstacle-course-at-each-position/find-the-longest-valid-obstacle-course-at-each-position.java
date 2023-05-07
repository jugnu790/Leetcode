class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] arr) {
        int n=arr.length;
        int ans[]=new int[n];
        int top=-1;
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            if(top==-1||a[top]<=arr[i])
            {
                a[++top]=arr[i];
                ans[i]=top+1;
            }
            else 
            {
                int index=bs(a,0,top,arr[i]);
                //System.out.println(a+"/"+index+"/"+arr[i]);
                a[index]=arr[i];
                //System.out.println("after->"+i+"/"+a+"/"+index+"/"+arr[i]);
                ans[i]=index+1;

            }
            // System.out.println("i-->"+i);
        }
        return ans;
    }
    int bs(int[] ans,int low,int high, int key){
       
        while(low <=high){
            int mid = low + (high - low)/2; 
            if(ans[mid]<= key){
                
                low = mid + 1;  
            }
            else{
                high = mid-1; 
            }
        }
        return high+1; 
    }
}