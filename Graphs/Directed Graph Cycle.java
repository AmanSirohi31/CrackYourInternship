class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                if(helper(i, adj, vis, pathVis))return true;
            }
        }
        return false;
    }
    
    private boolean helper(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathVis){
        vis[i] = true;
        pathVis[i] = true;
        for(int k=0; k<adj.get(i).size(); k++){
            if(!vis[adj.get(i).get(k)]){
                if(helper(adj.get(i).get(k), adj, vis, pathVis))return true;
            }else if(vis[adj.get(i).get(k)] && pathVis[adj.get(i).get(k)])return true;
        }
        pathVis[i] = false;
        return false;
    }
}
