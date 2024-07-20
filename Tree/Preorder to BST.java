static class Solution {
    // Function that constructs BST from its preorder traversal.
    public Node Bst(int pre[], int size) {
        int[] idx = new int[1];
        idx[0] = 0;
        return construct(pre, Integer.MAX_VALUE, idx);
    }
    public Node construct(int[] pre, int bound, int[] idx){
        if(idx[0]==pre.length || pre[idx[0]]>bound){
            return null;
        }
        Node root = new Node(pre[idx[0]]);
        idx[0]+=1;
        root.left = construct(pre, root.data, idx);
        root.right = construct(pre, bound, idx);
        return root;
    }
}
