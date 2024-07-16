class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, -1);
    }
    public int helper(TreeNode root, int leaf){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            if(leaf==1){
                return root.val;
            }else{
                return 0;
            }
        }else{
            int l = helper(root.left, 1);
            int r = helper(root.right, 0);
            
            return l+r;
        }
    }
}
