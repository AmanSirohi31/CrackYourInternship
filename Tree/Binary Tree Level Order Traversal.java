class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> al = new ArrayList<>();
        while(q.size()>0){
            TreeNode curr = q.remove();
            if(curr==null){
                ans.add(al);
                al=new ArrayList<>();
                if(!q.isEmpty()){
                    q.add(null);
                }
            }else{
                al.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        return ans;
    }
}
