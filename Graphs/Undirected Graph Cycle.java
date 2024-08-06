class Solution {
    class Pair{
        int node;
        int par;
        Pair(int node, int par){
            this.node = node;
            this.par = par;
        }
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                if(helper(i, V, adj, vis)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(int cur, int V, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(cur, -1));
        while(!q.isEmpty()){
            Pair p = q.remove();
            vis[p.node] = true;
            for(int i=0; i<adj.get(p.node).size(); i++){
                if(!vis[adj.get(p.node).get(i)]){
                    q.add(new Pair(adj.get(p.node).get(i), p.node));
                }else if(vis[adj.get(p.node).get(i)] && adj.get(p.node).get(i) != p.par){
                    return true;
                }
            }
        }
        return false;
    }
}
