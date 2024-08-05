class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        q.add(0);
        
        ArrayList<Integer> bfs = new ArrayList<>();
        while(!q.isEmpty()){
            int cur = q.remove();
            if(!vis[cur]){
                vis[cur] = true;
                bfs.add(cur);
                for(int i=0; i<adj.get(cur).size(); i++){
                    q.add(adj.get(cur).get(i));
                }
            }
        }
        return bfs;
    }
}
