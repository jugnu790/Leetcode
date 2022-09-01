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
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        return 1 
            + recGoodNodes(root.left, val) 
            + recGoodNodes(root.right, val);
    }
    
    public int recGoodNodes(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        int val = node.val;
        if (val >= max) {
            max = val;
            res = 1;
        }
        res += recGoodNodes(node.left, max);
        res += recGoodNodes(node.right, max);
        return res;
    }
}