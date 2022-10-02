/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
       // Scanner scn = new Scanner(System.out);
        if(n==1){
            return 1;
        }
        int l=0;
        int h=n-1;
        //int minIdx = Integer.MAX_VALUE;
        while(l<=h){
            int m = l+(h-l)/2;
            if(isBadVersion(m)){
                h=m-1;
            }
            else {
                l= m+1;
            }
        }
        return l;
    }
}