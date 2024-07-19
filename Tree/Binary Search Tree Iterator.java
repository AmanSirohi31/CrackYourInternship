class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        pushAll(root);
    }
    
    public int next() {
        TreeNode ans = st.pop();
        pushAll(ans.right);
        return ans.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    private void pushAll(TreeNode node){
        while(node!=null){
            st.push(node);
            node = node.left;
        }
    }
}
