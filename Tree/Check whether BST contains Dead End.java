class Solution
{
    public static boolean isDeadEnd(Node root)
    {
        ArrayList<Integer> inOrder = new ArrayList<>();
        HashMap<Node, Integer> leaf = new HashMap<>();
        inorder(root, inOrder, leaf);
        int suc;
        int pre;
        int myVal;
        for(int idx : leaf.values()){
            myVal = inOrder.get(idx);
            if(idx==0 && idx==inOrder.size()-1){
                pre=0;
                suc=10001;
            }
            else if(idx==0){
                pre=0;
                suc = inOrder.get(idx+1);
            }else if(idx==inOrder.size()-1){
                pre = inOrder.get(idx-1);
                suc = 10001;
            }else{
                pre = inOrder.get(idx-1);
                suc = inOrder.get(idx+1);
            }
            if(myVal-1==pre && myVal+1==suc){
                return true;
            }
            
        }
        return false;
    }
    public static void inorder(Node root, ArrayList<Integer> in, HashMap<Node, Integer> leaf){
        if(root==null){
            return;
        }
        inorder(root.left, in, leaf);
        in.add(root.data);
        if(root.left==null && root.right==null){
            leaf.put(root, in.size()-1);
        }
        inorder(root.right, in, leaf);
    }
}
