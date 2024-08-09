class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] pathVis = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                detectCycle(i, graph, vis, pathVis);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<pathVis.length; i++){
            if(pathVis[i]==false){
                ans.add(i);
            }
        }
        
        return ans;
    }
    private boolean detectCycle(int i, int[][] graph, boolean[] vis, boolean[] pathVis){
        vis[i] = true;
        pathVis[i] = true;
        
        for(int k=0; k<graph[i].length; k++){
            if(!vis[graph[i][k]]){
                if(detectCycle(graph[i][k], graph, vis, pathVis)){
                    return true;
                }
                
            }else if(pathVis[graph[i][k]]){
                    return true;
            }
        }

        pathVis[i] = false;
        return false;
    }
}
