class Solution{
    static class Info{
        int min;
        int max;
        int size;
        Info(int min, int max, int size){
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        return helper(root).size;
        
        
    }
    static Info helper(Node root){
        if(root==null){
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Info l = helper(root.left);
        Info r = helper(root.right);
        
        if(root.data>l.max && root.data<r.min){
            return new Info(Math.min(root.data, l.min), Math.max(root.data, r.max), 1+l.size+r.size);
        }
        
        return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(l.size, r.size));
    }
    
}
