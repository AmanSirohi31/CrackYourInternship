class Solution {
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        inorder(root, al);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<al.size()-1; i++){
            min = Math.min(min, Math.abs(al.get(i)-al.get(i+1)));
        }
        return min;
    }
    public void inorder(TreeNode root, ArrayList<Integer> in){
        if(root==null){
            return;
        }
        inorder(root.left, in);
        in.add(root.val);
        inorder(root.right, in);
    }
}
