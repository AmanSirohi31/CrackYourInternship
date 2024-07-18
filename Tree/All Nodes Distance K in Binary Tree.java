class Solution {
    private void parent(TreeNode root, HashMap<TreeNode, TreeNode> par){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        par.put(root, null);
        while(!q.isEmpty()){
            TreeNode cur = q.remove();
            if(cur.left!=null){
                q.add(cur.left);
                par.put(cur.left, cur);
            }
            if(cur.right!=null){
                q.add(cur.right);
                par.put(cur.right, cur);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> par = new HashMap<>();
        parent(root, par);
        HashMap<TreeNode, Boolean> vis = new HashMap<>();
        int curDist=0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        vis.put(target, true);
        while(!q.isEmpty()){
            int sz = q.size();
            if(curDist==k){
                break;
            }
            for(int i=0; i<sz; i++){
                TreeNode curr = q.remove();
                if(curr.left!=null && !vis.containsKey(curr.left)){
                    q.add(curr.left);
                    vis.put(curr.left, true);
                }
                if(curr.right!=null && !vis.containsKey(curr.right)){
                    q.add(curr.right);
                    vis.put(curr.right, true);
                }
                if(par.get(curr)!=null && !vis.containsKey(par.get(curr))){
                    q.add(par.get(curr));
                    vis.put(par.get(curr), true);
                }
            }
            curDist++;
        }
        List<Integer> l = new ArrayList<>();
        while(!q.isEmpty()){
            l.add(q.remove().val);
        }
        return l;
    }
}
