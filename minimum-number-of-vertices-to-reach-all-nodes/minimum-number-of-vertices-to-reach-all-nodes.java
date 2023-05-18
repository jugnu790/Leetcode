class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int degree[]=new int[n];
        for(int i=0;i<edges.size();i++){
            degree[edges.get(i).get(1)]++;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==0) ans.add(i);
        }
        return ans;
    }
}