

class Solution {
    Node[] copyNodes = new Node[100];
    
    public Node cloneGraph(Node node) 
    {
        if (node == null) return null; // stupid null nodes
        
        int ind = node.val-1; // So I don't have to write "node.val-1" all the time
        if (copyNodes[ind] == null) 
        {
            copyNodes[ind] = new Node(node.val); 
            for (Node neighbor : node.neighbors) 
                copyNodes[ind].neighbors.add(cloneGraph(neighbor));
        }
        return copyNodes[ind]; // Just return the copied node if it exists.
    }
}