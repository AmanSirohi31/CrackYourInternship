class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder asf = new StringBuilder();
        List<String> ans = new ArrayList<>();
        helper(root, asf, ans);
        return ans;
    }
    public void helper(TreeNode root, StringBuilder asf, List<String> al){
        if(root==null){
            return;
        }
        asf.append(String.valueOf(root.val));
        if(root.left==null && root.right==null){
            al.add(asf.toString());
            return;
        }else{
            asf.append("->");
            helper(root.left, asf, al);
            helper(root.right, asf, al);
        }
        
        
    }
}
