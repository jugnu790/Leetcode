/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        List<Node> previousLayer = Arrays.asList(root);
        while (!previousLayer.isEmpty()) {
            List<Node> currentLayer = new ArrayList<>();
            List<Integer> previousVals = new ArrayList<>();
            for (Node node: previousLayer) {
                previousVals.add(node.val);
                currentLayer.addAll(node.children);
            }
            result.add(previousVals);
            previousLayer = currentLayer;
        }
        return result;
    }
}