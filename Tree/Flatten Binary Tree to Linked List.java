class Solution {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        ArrayList<TreeNode> pre = new ArrayList<>();
        preorder(root, pre);
        TreeNode cur = root;
        int i=1;
        while(i<pre.size()){
            cur.right = pre.get(i);
            cur.left = null;
            cur=cur.right;
            i++;
        }
        return;
    }
    public void preorder(TreeNode root, ArrayList<TreeNode> pre){
        if(root==null){
            return;
        }
        pre.add(root);
        preorder(root.left, pre);
        preorder(root.right, pre);
    }
}
