class Solution {
    public double findMedianSortedArrays( int A[], int B[]) {
        int n = A.length;
        int m = B.length;
        if (n > m)
            return findMedianSortedArrays(B, A); // Swapping to make A smaller
 
        int start = 0;
        int end = n;
        int realmidinmergedarray = (n + m + 1) / 2;
 
        while (start <= end) {
            int mid = (start + end) / 2;
            int leftAsize = mid;
            int leftBsize = realmidinmergedarray - mid;
            int leftA = (leftAsize > 0)? A[leftAsize - 1]: Integer.MIN_VALUE;
            int leftB
                    = (leftBsize > 0) ? B[leftBsize - 1] : Integer.MIN_VALUE;
            int rightA
                    = (leftAsize < n) ? A[leftAsize] : Integer.MAX_VALUE;
            int rightB
                    = (leftBsize < m) ? B[leftBsize] : Integer.MAX_VALUE;
 
            // if correct partition is done
            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0)
                    return (Math.max(leftA, leftB)
                            + Math.min(rightA, rightB))
                            / 2.0;
                return Math.max(leftA, leftB);
            }
        else if (leftA > rightB) {
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return 0.0;
    }
}