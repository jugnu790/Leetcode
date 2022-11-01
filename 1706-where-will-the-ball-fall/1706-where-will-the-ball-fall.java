class Solution {
    public int[] findBall(int[][] grid) {
        int[] res = new int[grid[0].length];
        for(int i = 0; i < grid[0].length; i++){
            int row = 0;
            int col = i;
            while(row < grid.length){
                if(grid[row][col] == 1){
                    if(col == grid[0].length - 1 || grid[row][col + 1] == -1){
                        res[i] = -1;
                        break;
                    }
                    else{
                        col++;
                        row++;
                    }
                }
                else{
                    if(col == 0 || grid[row][col - 1] == 1){
                        res[i] = -1;
                        break;
                    }
                    else{
                        col--;
                        row++;
                    }
                }
            }
            if(row == grid.length) res[i] = col;
        }
        return res;
    }
}