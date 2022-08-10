/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode d1, TreeNode d2) {
        if (node == null) {
            return null ;
        }
        if(d1.val<node.val && d2.val<node.val){
            return lowestCommonAncestor(node.left,d1,d2);
        }else if(d1.val>node.val && d2.val > node.val){
            return lowestCommonAncestor(node.right,d1,d2);
        }else{
            return node;
        }
    }
}