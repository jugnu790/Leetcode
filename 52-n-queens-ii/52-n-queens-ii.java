class Solution {
     private boolean[] col; // column
    private boolean[] dia1; // normal diagonal
    private boolean[] dia2; // reverse diagonal
    private int count;
    
    private boolean isSafeToPlace(int i, int j, int n) {
        if(col[j] == true) return false;
        else if(dia1[i + j] == true) return false;
        else if(dia2[i - j + n - 1] == true) return false;
        else return true;
    }
    
    private void nQueen(int row, int n) {
        if(row == n) {
            count++;
            return;
        }
        
        for(int c = 0; c < n; c++) {
            if(isSafeToPlace(row, c, n)) {
                col[c] = true;
                dia1[row + c] = true;
                dia2[row - c + n - 1] = true;
                
                nQueen(row + 1, n);
                
                col[c] = false;
                dia1[row + c] = false;
                dia2[row - c + n - 1] = false;
            }
        }
    }
    
    
    public int totalNQueens(int n) {
        if(n == 1) return 1;
        else if(n == 2 || n == 3) {
            return 0;
        }
        
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        count = 0;
        nQueen(0, n);
        return count;
    }

}