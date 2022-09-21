class Solution {
     public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[queries.length];
        
        // Get initial even summation
        int sum = 0;
        for (int i = 0; i < A.length; i++) sum += (A[i] % 2 == 0) ?  A[i] : 0;
        
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][1];
            int value = queries[i][0];
            int previousValue = A[index];
            
            boolean wasEven = false;
            boolean nowEven = false;
            
            if (A[index] % 2 == 0) wasEven = true;
            A[index] += value;
            if (A[index] % 2 == 0) nowEven = true;
            
            if (wasEven && nowEven) { // was even before and after
                sum += value;
            } else if (wasEven && !nowEven) { // was even and now odd
                sum -= previousValue;
            } else if (!wasEven && nowEven) { // was odd and became even
                sum += A[index];
            } else if (!wasEven && !nowEven) {} // was odd then and still odd now, do nothing
            res[i] = sum;  
        }
        return res;
    }
}