class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean validate(TreeNode root, long min, long max){
        if(root==null){
            return true;
        }
        if(root.val<=min || root.val>=max){
            return false;
        }
        boolean l = validate(root.left, min, root.val);
        boolean r = validate(root.right, root.val, max);
        return l&&r;
    }
}
