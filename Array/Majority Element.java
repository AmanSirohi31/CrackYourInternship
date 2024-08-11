class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int cur = -1;
        for(int i=0; i<nums.length; i++){
            if(cur==-1){
                cur = nums[i];
                count = 1;
            }else{
                if(cur!=nums[i]){
                    count--;
                    if(count==0){
                        cur = -1;
                    }
                }else{
                    count++;
                }
            }
        }
        return cur;
    }
}
