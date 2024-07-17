class Solution {
    class Info{
        TreeNode node;
        int idx;
        Info(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root, 0));
        int width = 0;
        int first = 0;
        int last = 0;
        while(!q.isEmpty()){
            int m = q.peek().idx;
            int sz = q.size();
            for(int i=0; i<sz; i++){
                int curId = q.peek().idx-m;
                Info inf = q.remove();
                if(i==0){
                    first = inf.idx;
                }
                if(i==sz-1){
                    last = inf.idx;
                }
                
                if(inf.node.left!=null){
                    q.add(new Info(inf.node.left, curId*2+1));
                }
                if(inf.node.right!=null){
                    q.add(new Info(inf.node.right, curId*2+2));
                }
                width = Math.max(width, last-first+1);
            }
        }
        return width;
    }
}
