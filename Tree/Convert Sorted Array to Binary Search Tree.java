class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    public TreeNode helper(int[] nums, int st, int end){
        if(end<st){
            return null;
        }
        int mid = (st+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, st, mid-1);
        root.right = helper(nums, mid+1, end);
        return root;
    }
}
