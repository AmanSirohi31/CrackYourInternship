class GfG {
    int findDist(Node root, int a, int b) {
        Node myLca = lca(root, a, b);
        return dist(myLca, a) + dist(myLca, b) - 2;
    }
    Node lca(Node root, int a, int b){
        if(root==null){
            return null;
        }
        if(root.data==a || root.data==b){
            return root;
        }
        Node l = lca(root.left, a, b);
        Node r = lca(root.right, a, b);
        if(l!=null && r!=null){
            return root;
        }else if(r==null){
            return l;
        }else{
            return r;
        }
    }
    int dist(Node root, int n){
        if(root==null){
            return 0;
        }
        if(root.data==n){
            return 1;
        }
        int l = dist(root.left, n);
        int r = dist(root.right, n);
        if(l==0 && r==0){
            return 0;
        }
        return Math.max(l, r)+1;
    }
}
