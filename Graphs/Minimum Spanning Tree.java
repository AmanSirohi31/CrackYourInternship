class Solution {
    static class Info{
        int node;
        int par;
        int wt;
        Info(int node, int par, int wt){
            this.node = node;
            this.par = par;
            this.wt = wt;
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Info> pq = new PriorityQueue<>((x, y) -> x.wt - y.wt);
        boolean[] vis = new boolean[V];
        int ans = 0;
        pq.add(new Info(0, -1, 0));
        while(!pq.isEmpty()){
            Info cur = pq.remove();
            if(!vis[cur.node]){
                vis[cur.node] = true;
                ans+=cur.wt;
                for(int i=0; i<adj.get(cur.node).size(); i++){
                    pq.add(new Info(adj.get(cur.node).get(i)[0], cur.node, adj.get(cur.node).get(i)[1]));
                }
            }
        }
        return ans;
        
    }
}
