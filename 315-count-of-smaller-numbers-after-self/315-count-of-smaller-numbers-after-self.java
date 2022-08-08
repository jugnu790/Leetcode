class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
 
        if (nums == null || nums.length == 0) {
            return list;
        }
 
        int len = nums.length;
 
        int[] idxs = new int[len];
        int[] count = new int[len];
 
        for (int i = 0; i < len; i++)
            idxs[i] = i;
 
        mergeSort(nums, idxs, 0, len, count);
 
        for (int i : count)
            list.add(i);
 
        return list;
    }
 
    private void mergeSort(int[] nums, int[] idxs, int start, int end, int[] count) {
        if (start + 1 >= end)
            return;
 
        int mid = (end - start) / 2 + start;
        mergeSort(nums, idxs, start, mid, count);
        mergeSort(nums, idxs, mid, end, count);
 
        merge(nums, idxs, start, end, count);
    }
 
    private void merge(int[] nums, int[] idxs, int start, int end, int[] count) {
 
        int mid = (end - start) / 2 + start;
 
        int[] tmpIdx = new int[end - start];
        int i = start, j = mid, k = 0;
 
        while (k < end - start) {
            if (i < mid) {
                if (j < end && nums[idxs[j]] < nums[idxs[i]]) {
                    tmpIdx[k++] = idxs[j++];
                } else {
                    count[idxs[i]] += j - mid;
                    tmpIdx[k++] = idxs[i++];
                }
            } else {
                tmpIdx[k++] = idxs[j++];
            }
        }
 
        System.arraycopy(tmpIdx, 0, idxs, start, end - start);
    }
}