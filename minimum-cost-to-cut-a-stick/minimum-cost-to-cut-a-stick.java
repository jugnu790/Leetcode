class Solution {
    Map<ArrayList<Integer>, Integer> map;
    public int minCost(int n, int[] cuts) {
        map = new HashMap<>();
        return cost(cuts, 0, n);
    }
    public int cost(int cuts[], int l, int r) {
        ArrayList<Integer> ind = new ArrayList<>();
        ind.add(l); ind.add(r);
        if(map.containsKey(ind)) return map.get(ind);
        int min = Integer.MAX_VALUE;
        for(int i : cuts) {
            if(i <= l || i >= r) continue;
            int temp = cost(cuts, l, i);
            temp += cost(cuts, i, r);
            min = Math.min(temp + r - l, min);
        }
        if(min == Integer.MAX_VALUE) {
            min = 0;
        }
        map.put(ind, min);
        return min;
    }
}