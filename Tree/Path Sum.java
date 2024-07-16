class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, 0, targetSum);
    }
    public boolean helper(TreeNode root, int currSum, int targetSum){
        if(root==null){
            return false;
        }
        currSum+=root.val;
        if(root.left==null && root.right==null){
            if(currSum==targetSum){
                return true;
            }
        }else{
            boolean l = helper(root.left, currSum, targetSum);
            boolean r = helper(root.right, currSum, targetSum);
            return l||r;
        }
        return false;
    }
}
