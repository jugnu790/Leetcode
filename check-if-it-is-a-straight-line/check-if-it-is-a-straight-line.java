class Solution {
    // public boolean checkStraightLine(int[][] coordinates) {
    // coordinates --> c
    public boolean checkStraightLine(int[][] c) {
        
        
        int xMove = c[1][0] - c[0][0];
        int yMove = c[1][1] - c[0][1];
        
        for(int i=1; i<c.length; i++){

            int x = c[i][0] - c[i-1][0];
            int y = c[i][1] - c[i-1][1];
            
// linear function -> y = k * x + b;
// Here need to discuss y = k * x;
// k = yMove / xMove;
// y * xMove = x * yMove;
            
            if(y * xMove != x * yMove) return false;
        }
        
        return true;
    }
}