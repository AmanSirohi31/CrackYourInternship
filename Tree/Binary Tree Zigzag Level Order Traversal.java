class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean LtoR = true;
        List<List<Integer>> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i=0; i<sz; i++){
                TreeNode curr = q.remove();
                if(LtoR){
                    l.add(curr.val);
                }
                else{
                    l.add(0,curr.val);
                } 
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            ans.add(l);
            if(LtoR==true){
                LtoR=false;
            }else{
                LtoR=true;
            }
        }
        return ans;
        
    }
}
