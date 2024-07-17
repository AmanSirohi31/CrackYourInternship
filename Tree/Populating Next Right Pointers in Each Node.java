class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        helper(root, null, 'o');
        return root;
    }
    public void helper(Node root, Node par, char ch){
        if(root==null){
            return;
        }
        if(ch=='l'){
            if(par.right!=null){
                root.next=par.right;
            }
        }else if(ch=='r'){
            if(par.next!=null){
                root.next=par.next.left;
            }
        }
        helper(root.left, root, 'l');
        helper(root.right, root, 'r');
    }
}
