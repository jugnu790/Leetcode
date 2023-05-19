class Solution {
    public boolean checkGraph(int[][] graph,int idx,int currColor,int[] color)
    {
        if(color[idx]!=0)
            return color[idx]==currColor;
        color[idx]=currColor;
        for(int next : graph[idx])
            if(!checkGraph(graph,next,-currColor,color))
                return false;
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i=0;i<graph.length;i++)
            if(color[i]==0 && !checkGraph(graph,i,1,color))
                return false;
        return true;
    }
}