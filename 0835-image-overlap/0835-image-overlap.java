class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        int[][] count = new int[2*n+1][2*n+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(A[i][j] == 1){
                    for(int k = 0; k < n; k++){
                        for(int l = 0; l < n; l++){
                            if(B[k][l] == 1){
                                count[k-i+n][l-j+n]++;
                            }
                        }
                    }
                }
            }
        }
        int max = 0;
        for(int i = 0; i < 2*n+1; i++){
            for(int j = 0; j < 2*n+1; j++){
                max = Math.max(max, count[i][j]);
            }
        }
        return max;
    }
}