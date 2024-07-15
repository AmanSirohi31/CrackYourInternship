class Solution {
    class Info{
        int ht;
        int dia;
        Info(int ht, int dia){
            this.ht = ht;
            this.dia = dia;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return calc(root).dia-1;
    }
    public Info calc(TreeNode root){
        if(root==null){
            return new Info(0, 0);
        }
        
        Info l = calc(root.left);
        Info r = calc(root.right);

        int h = Math.max(l.ht, r.ht)+1;
        int d = Math.max(l.ht+r.ht+1, Math.max(l.dia, r.dia));
        return new Info(h, d);
    }
}
