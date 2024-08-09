class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(i, adj, vis, st);
            }
        }
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i=0; i<V; i++){
            adjT.add(new ArrayList<>());
        }
        for(int i=0; i<V; i++){
            for(int j=0; j<adj.get(i).size(); j++){
                adjT.get(adj.get(i).get(j)).add(i);
            }
        }
        vis = new boolean[V];
        int count = 0;
        while(!st.isEmpty()){
            if(!vis[st.peek()]){
                dfs2(st.peek(), adjT, vis);
                count++;
            }
            st.pop();
        }
        return count;
    }
    public void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st){
        vis[i] = true;
        for(int k=0; k<adj.get(i).size(); k++){
            if(!vis[adj.get(i).get(k)])dfs(adj.get(i).get(k), adj, vis, st);
        }
        st.push(i);
    }
    public void dfs2(int i, ArrayList<ArrayList<Integer>> adjT, boolean[] vis){
        vis[i] = true;
        for(int k=0; k<adjT.get(i).size(); k++){
            if(!vis[adjT.get(i).get(k)])dfs2(adjT.get(i).get(k), adjT, vis);
        }
    }
}
