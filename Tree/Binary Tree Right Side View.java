class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
        
    }
    public void helper(TreeNode root, int lvl, List<Integer> al){
        if(root==null){
            return;
        }
        if(al.size()==lvl){
            al.add(root.val);
        }
        helper(root.right, lvl+1, al);
        helper(root.left, lvl+1, al);
    }
}
