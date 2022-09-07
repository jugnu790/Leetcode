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
public String tree2str(TreeNode root) {
        if (root == null) return "";
        String res = root.val + "";
        String left = tree2str(root.left);
        String right = tree2str(root.right);
        if (left == "" && right == "") return res;
        if (left == "") return res + "()" + "(" + right + ")";
        if (right == "") return res + "(" + left + ")";
        return res + "(" + left + ")" + "(" + right + ")";
    }
}