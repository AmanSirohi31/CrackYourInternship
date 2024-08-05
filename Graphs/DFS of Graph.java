class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        
        helper(0, adj, vis, dfs);
        return dfs;
    }
    private void helper(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> dfs){
        vis[i]=true;
        dfs.add(i);
        for(int k=0; k<adj.get(i).size(); k++){
            if(!vis[adj.get(i).get(k)]){
                helper(adj.get(i).get(k), adj, vis, dfs);
            }
        }
    }
}
