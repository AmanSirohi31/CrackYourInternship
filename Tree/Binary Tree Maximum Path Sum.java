class Solution {
    public int maxPathSum(TreeNode root) {
        ArrayList<Integer> maxi = new ArrayList<>();
        maxi.add(Integer.MIN_VALUE);
        int r = helper(root, maxi);
        return maxi.get(maxi.size()-1);
    }
    public int helper(TreeNode root, ArrayList<Integer> maxi){
        if(root==null){
            return 0;
        }
        int leftSum = helper(root.left, maxi);
        int rightSum = helper(root.right, maxi);
        if(leftSum<0){
            leftSum=0;
        }
        if(rightSum<0){
            rightSum=0;
        }
        maxi.add(Math.max(maxi.get(maxi.size()-1), root.val+leftSum+rightSum));
        return root.val+Math.max(leftSum, rightSum);
    }
}
