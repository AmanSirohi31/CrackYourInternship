class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(int k=0; k<V; k++){
            if(!map.containsKey(k)){
                map.put(k, 0);
                q.add(k);
                while(!q.isEmpty()){
                    int cur = q.remove();
                   
                    for(int i=0; i<adj.get(cur).size(); i++){
                        if(!map.containsKey(adj.get(cur).get(i))){
                            int myColor = map.get(cur)==1 ? 0 : 1; 
                            q.add(adj.get(cur).get(i));
                            map.put(adj.get(cur).get(i), myColor);
                        }else{
                            if(map.get(cur)==map.get(adj.get(cur).get(i)))return false;
                        }
                        
                    }
                }
            }
        }
        return true;
    }
}
