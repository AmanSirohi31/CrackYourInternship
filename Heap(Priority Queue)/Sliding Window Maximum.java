class Solution {
    class Pair{
        int num;
        int idx;
        Pair(int num, int idx){
            this.num = num;
            this.idx = idx;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.num-x.num);
        int i=1;
        int j;
        int[] ans = new int[nums.length-k+1];
        for(j=0; j<k; j++){
            pq.add(new Pair(nums[j], j));
        }
        ans[0] = pq.peek().num;
        while(j<nums.length){
            pq.add(new Pair(nums[j], j));
            while(pq.peek().idx<i){
                pq.remove();
            }
            ans[i] = pq.peek().num;
            i++;
            j++;
        }
        return ans;
    }
}
