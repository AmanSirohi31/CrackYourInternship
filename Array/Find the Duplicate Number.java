class Solution {
    public int findDuplicate(int[] nums) {
        int[] arr = new int[nums.length];
        int i;
        for(i=0; i<nums.length; i++){
            if(arr[nums[i]]==0){
                arr[nums[i]] = 1;
            }else{
                break;
            }
        }
        return nums[i];
    }
}
