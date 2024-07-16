class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> l = inorderTraversal(root.left);
        List<Integer> r = inorderTraversal(root.right);

        l.add(root.val);
        int i=r.size();
        for(int k=0; k<i; k++){
            l.add(r.get(k));
        }
        return l;
    }
}
