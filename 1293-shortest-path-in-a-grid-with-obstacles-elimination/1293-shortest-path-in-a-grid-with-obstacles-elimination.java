class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][][] visited = new boolean[m][n][k + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, k});
        visited[0][0][k] = true;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                int rem = curr[2];
                if (x == m - 1 && y == n - 1) {
                    return step;
                }
                for (int[] d : dir) {
                    int nextX = x + d[0];
                    int nextY = y + d[1];
                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                        continue;
                    }
                    int nextRem = rem - grid[nextX][nextY];
                    if (nextRem < 0 || visited[nextX][nextY][nextRem]) {
                        continue;
                    }
                    q.offer(new int[]{nextX, nextY, nextRem});
                    visited[nextX][nextY][nextRem] = true;
                }
            }
            step++;
        }
        return -1;
    }
}