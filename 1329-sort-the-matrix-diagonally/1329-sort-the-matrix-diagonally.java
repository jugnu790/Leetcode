class Solution {
        private static final int R = 101;
        private static int ROW, COL;
        public int[][] diagonalSort(int[][] mat) {
            if (mat.length <= 1 || mat[0].length <= 1) return mat;
            ROW = mat.length;
            COL = mat[0].length;
            for (int row = R-2; row > 0; row--)
                radixSort(mat, row, 0);
            for (int col = 0; col < COL-1; col++)
                radixSort(mat, 0, col);
            return mat;
        }

        private void radixSort(int[][] mat, int row, int col) {
            int[] count = new int[R];
            for (int i = row, j = col; i < ROW && j < COL; i++, j++)
                count[mat[i][j]]++;
            for (int i = row, j = col, d = 1; i < ROW && j < COL; d++)
                while (count[d]-- > 0) mat[i++][j++] = d;
        }
}