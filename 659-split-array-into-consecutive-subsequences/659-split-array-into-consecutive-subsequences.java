class Solution {
    public boolean isPossible(int[] nums) {
        PriorityQueue<interval> queue = new PriorityQueue<>((a, b) -> (a.end == b.end ? a.len - b.len : a.end - b.end));
        for (int num : nums) {
            while (!queue.isEmpty() && queue.peek().end + 1 < num) {
                if (queue.poll().len < 3) return false;
            }
            if (queue.isEmpty() || queue.peek().end == num) queue.offer(new interval(num, num));
            else { //num == end + 1
                queue.add(new interval(queue.poll().start, num));
            }
        }
        while (!queue.isEmpty()) {
            if (queue.poll().len < 3) return false;
        }
        return true;
    }
    
    class interval {
        int start, end, len;
        public interval(int start, int end) {
            this.start = start;
            this.end = end;
            this.len = end - start + 1;
        }
    }
}