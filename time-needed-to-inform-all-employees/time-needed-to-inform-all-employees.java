class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] arr = new ArrayList[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                arr[manager[i]].add(i);
            }
        }

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(headID, informTime[headID]));

        while (!q.isEmpty()) {
            int si = q.size();

            for (int i = 0; i < si; i++) {
                Pair<Integer, Integer> t = q.poll();

                for (int x : arr[t.getKey()]) {
                    if (informTime[x] == 0) {
                        ans = Math.max(ans, t.getValue());
                    } else {
                        q.offer(new Pair<>(x, t.getValue() + informTime[x]));
                    }
                }
            }
        }

        return ans;
    }
}