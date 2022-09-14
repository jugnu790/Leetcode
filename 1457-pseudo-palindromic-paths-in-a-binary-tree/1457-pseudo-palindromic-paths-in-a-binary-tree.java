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
class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root, 0);
         
    }
    private int dfs(TreeNode root, int i) {
        if (root == null) {
            return 0;
        }
        i ^= 1 << root.val;
        if (root.left == null && root.right == null) {
            return Integer.bitCount(i) <= 1 ? 1 : 0;
        }
        return dfs(root.left, i) + dfs(root.right, i);
    }
}
