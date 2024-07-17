class Solution {
    class Info{
        TreeNode node;
        int col;
        int row;
        Info(TreeNode node, int col, int row){
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root, 0, 0));
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            Info cur = q.remove();
            TreeNode curNode = cur.node;
            int y = cur.col;
            int x = cur.row;
            if(!map.containsKey(y)){
                map.put(y, new TreeMap<>());
            }
            if(!map.get(y).containsKey(x)){
                map.get(y).put(x, new PriorityQueue<>());
            }
            map.get(y).get(x).add(curNode.val);

            if(curNode.left!=null){
                q.add(new Info(curNode.left, y-1, x+1));
                minCol = Math.min(minCol, y-1);
            }
            if(curNode.right!=null){
                q.add(new Info(curNode.right, y+1, x+1));
                maxCol = Math.max(maxCol, y+1);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> mp : map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : mp.values()){
                while(pq.size()!=0){
                    ans.get(ans.size()-1).add(pq.remove());
                }
            }
        }
        
        return ans;
    }
}
