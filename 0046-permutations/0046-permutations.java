class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        permuteHelper(result, list, 0);
        return result;
    }

    private void permuteHelper(List<List<Integer>> result, List<Integer> list, int i) {
        if (i == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < list.size(); j++) {
            Collections.swap(list, i, j);
            permuteHelper(result, list, i + 1);
            Collections.swap(list, i, j);
        }
    }
}
