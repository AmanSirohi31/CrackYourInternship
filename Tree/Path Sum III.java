class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, 0, new ArrayList<>(), 0);
    }
        
    public int helper(TreeNode root, int targetSum, int curSum, ArrayList<Integer> nums, long st){
        if(root==null){
            return 0;
        }
        
        int count=0;
        curSum+=root.val;
        nums.add(root.val);
        long sum=0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            sum += nums.get(i);
            if (sum == targetSum) {
                count++;
            }
        }

        int l = helper(root.left, targetSum, curSum, nums, st);
        int r = helper(root.right, targetSum, curSum, nums, st);
        nums.remove(nums.size()-1);
        return l+r+count;
    }
}
