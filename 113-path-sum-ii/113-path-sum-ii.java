/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSum(root, sum, path, result);
        return result;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new ArrayList<>(path));
        } else {
            pathSum(root.left, sum - root.val, path, result);
            pathSum(root.right, sum - root.val, path, result);
        }
        path.remove(path.size() - 1);
    }
}