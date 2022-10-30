class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] visited = new int[m][n][k+1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int l = 0; l <= k; l++){
                    visited[i][j][l] = Integer.MAX_VALUE;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,k});
        visited[0][0][k] = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int remain = cur[2];
            if(x == m-1 && y == n-1){
                return visited[x][y][remain];
            }
            for(int[] dir : dirs){
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n){
                    continue;
                }
                if(grid[nx][ny] == 1){
                    if(remain > 0 && visited[nx][ny][remain-1] > visited[x][y][remain] + 1){
                        visited[nx][ny][remain-1] = visited[x][y][remain] + 1;
                        queue.add(new int[]{nx,ny,remain-1});
                    }
                }else{
                    if(visited[nx][ny][remain] > visited[x][y][remain] + 1){
                        visited[nx][ny][remain] = visited[x][y][remain] + 1;
                        queue.add(new int[]{nx,ny,remain});
                    }
                }
            }
        }
        return -1;
    }
}