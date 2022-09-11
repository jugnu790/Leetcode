class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = efficiency[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long res = 0;
        for (int i = 0; i < n; i++) {
            pq.add(arr[i][1]);
            sum += arr[i][1];
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            res = Math.max(res, sum * arr[i][0]);
        }
        return (int) (res % 1000000007);      
    }
}