class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        pushAll(root, st);
        int i=0;
        while(!st.isEmpty()){
            TreeNode cur = st.pop();
            i++;
            if(i==k){
                return cur.val;
            }
            pushAll(cur.right, st);
        }
        return 0;
    }
    public void pushAll(TreeNode cur, Stack<TreeNode> st){
        while(cur!=null){
            st.push(cur);
            cur=cur.left;
        }
    }
    
}
