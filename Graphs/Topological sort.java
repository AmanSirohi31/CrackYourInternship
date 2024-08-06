class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(i, adj, vis, st);
            }
        }
        int[] ans = new int[st.size()];
        int i=0;
        while(!st.isEmpty()){
            ans[i] = st.pop();
            i++;
        }
        return ans;
    }
    static void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st){
        vis[i] = true;
        for(int k=0; k<adj.get(i).size(); k++){
            if(!vis[adj.get(i).get(k)]){
                dfs(adj.get(i).get(k), adj, vis, st);
            }
        }
        st.push(i);
    }
}
