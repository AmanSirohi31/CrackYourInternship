class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<postorder.length; i++){
            map.put(postorder[i], i);
        }
        int[] preIdx = new int[1];
        preIdx[0]=0;
        return helper(preorder, postorder, map, 0, postorder.length-1, preIdx);
    }
    public TreeNode helper(int[] preorder, int[] postorder, HashMap<Integer, Integer> map, int st, int end, int[] preIdx){
        if(st>end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIdx[0]]);
        preIdx[0]+=1;
        if(st==end){
            return root;
        }
        
        int index = map.get(preorder[preIdx[0]]);

        root.left = helper(preorder, postorder, map, st, index, preIdx);
        root.right = helper(preorder, postorder, map, index+1, end-1, preIdx);
        return root;
    }
}
