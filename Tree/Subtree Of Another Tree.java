class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }
        if(root.val==subRoot.val){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }

        boolean l = isSubtree(root.left, subRoot);
        boolean r = isSubtree(root.right, subRoot);
        return l||r;
    }
    public boolean isIdentical(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null){
            return true;
        }
        if(root==null || subRoot==null || root.val!=subRoot.val){
            return false;
        }
        boolean l = isIdentical(root.left, subRoot.left);
        boolean r = isIdentical(root.right, subRoot.right);
        return l&&r;
    }
}
