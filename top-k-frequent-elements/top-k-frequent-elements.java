class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    var freq = new HashMap<Integer, Integer>();
    var heap = new PriorityQueue<Pair<Integer, Integer>>((a,b) -> Integer.compare(a.getKey(), b.getKey()));
    var ans = new int[k];
    var i = 0;

    for (var n : nums)
      freq.put(n, freq.getOrDefault(n, 0) + 1);
    
    for (var e : freq.entrySet()) {
      heap.offer(new Pair(e.getValue(), e.getKey()));
      if (heap.size() > k) heap.poll();
    }
    while (!heap.isEmpty())
      ans[i++] = heap.poll().getValue();

    return ans;
  }
}