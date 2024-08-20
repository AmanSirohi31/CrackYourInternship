class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int size = 0;
        for(int i=0; i<nums.length; i++){
            if(size<k){
                pq.add(nums[i]);
                size++;
            }else{
                if(pq.peek()<nums[i]){
                    pq.remove();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}
