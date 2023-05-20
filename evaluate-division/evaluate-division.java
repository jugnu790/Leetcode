class Solution {
    HashMap<String, ArrayList<Pair>> graph = new HashMap<>();
    public class Pair{
        String v;
        double w;
        Pair(String v, double w){
            this.v = v;
            this.w = w;
        }
        public String toString(){
            return v + " " + w;
        }
    }
    
    public double dfs(String src, String dest, HashSet<String> vis){
        vis.add(src);
        if(src.equals(dest)) return 1;
        double ans = 1;
        for(Pair e : graph.get(src)){
            if(!vis.contains(e.v)){
                double ret = dfs(e.v, dest, vis);
                if(ret > 0) return e.w * ret;
            }
        }
        return -1.0;
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] qAnswer = new double[queries.size()];
        for(int i = 0 ; i < equations.size() ; i++){
            String u = equations.get(i).get(0), v = equations.get(i).get(1);
            double w = values[i];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, 1/w));
        }
        
        for(int i = 0 ; i < queries.size() ; i++){
            String u = queries.get(i).get(0), v = queries.get(i).get(1);
            double q = graph.containsKey(u) ? dfs(u, v, new HashSet<>()) : -1.0;
            qAnswer[i] = q;
        }
        
        return qAnswer;
    }
}