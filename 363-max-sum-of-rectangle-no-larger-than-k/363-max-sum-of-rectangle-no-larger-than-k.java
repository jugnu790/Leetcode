class Solution {
   public int maxSumSubmatrix(int[][] matrix, int k) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }

            int m = matrix.length;
            int n = matrix[0].length;

            int[][] preSum = new int[m][n + 1];

            for (int i = 0; i < m; i++) {
                for (int j = 1; j <= n; j++) {
                    preSum[i][j] = preSum[i][j - 1] + matrix[i][j - 1];
                }
            }

            int ans = Integer.MIN_VALUE;
            for (int c1 = 1; c1 <= n; c1++) {
                for (int c2 = c1; c2 <= n; c2++) {
                    int[] preSumRow = new int[m];
                    for (int row = 0; row < m; row++) {
                        preSumRow[row] = preSum[row][c2] - preSum[row][c1 - 1];
                    }

                    ans = Math.max(ans, getMaxSubarrayHelper(preSumRow, k));
                }
            }

            return ans;
        }

        private int getMaxSubarrayHelper(int[] nums, int target) {
            TreeSet<Integer> treeSet = new TreeSet<>();

            int ans = Integer.MIN_VALUE;
            int[] preSum = new int[nums.length + 1];

            for (int i = 1; i <= nums.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }

            treeSet.add(0);
            for (int i = 1; i <= nums.length; i++) {
                Integer num = preSum[i] - target;
                Integer ceiling = treeSet.ceiling(num);

                if (ceiling != null) {
                    ans = Math.max(ans, preSum[i] - ceiling);
                }

                treeSet.add(preSum[i]);
            }

            return ans;
        }
    }