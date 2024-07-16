class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isIdentical(root.left, root.right);
    }
    public boolean isIdentical(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null || root1.val!=root2.val){
            return false;
        }
        boolean l = isIdentical(root1.left, root2.right);
        boolean r = isIdentical(root1.right, root2.left);
        return l&&r;
    }
}
