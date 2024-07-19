class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        pre[0] = null;
        suc[0] = null;
        Node cur = root;
        while(cur!=null){
            if(cur.data>key){
                suc[0]=cur;
                cur=cur.left;
            }else if(cur.data<key){
                pre[0]=cur;
                cur=cur.right;
            }else{
                if(cur.right!=null){
                    Node r = cur.right;
                    while(r.left!=null){
                        r = r.left;
                    }
                    suc[0]=r;
                }
                if(cur.left!=null){
                    Node l = cur.left;
                    while(l.right!=null){
                        l = l.right;
                    }
                    pre[0]=l;
                }
                break;
            }
        }
    }
}
