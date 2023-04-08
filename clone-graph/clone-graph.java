/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Map<Node, Node> visited = new HashMap<>();
        return cloneGraphHelper(node, visited);
    }
    
    private Node cloneGraphHelper(Node node, Map<Node, Node> visited) {
        Node copy = new Node(node.val);
        visited.put(node, copy);
        for (Node neighbor : node.neighbors) {
            if (visited.containsKey(neighbor)) {
                copy.neighbors.add(visited.get(neighbor));
            } else {
                Node neighborCopy = cloneGraphHelper(neighbor, visited);
                copy.neighbors.add(neighborCopy);
            }
        }
        return copy;
    }
}