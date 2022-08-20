class Solution {
  public int minRefuelStops(int target, int startFuel, int[][] stations) {
    int ans = 0;
    int i = 0; 
    int curr = startFuel;
    Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    while (curr < target) {
      
      while (i < stations.length && curr >= stations[i][0])
        maxHeap.offer(stations[i++][1]);
      if (maxHeap.isEmpty()) 
        return -1;
      curr += maxHeap.poll(); 
      ++ans;                  
    }

    return ans;
  }
}
