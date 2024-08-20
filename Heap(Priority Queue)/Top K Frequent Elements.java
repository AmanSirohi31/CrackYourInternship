class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> map.get(x)-map.get(y));
        int[] ans = new int[k];
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        int pqSize = 0;
        for(Integer key : map.keySet()){
            if(pqSize<k){
                pq.add(key);
                pqSize++;
            }else{
                if(map.get(pq.peek())<map.get(key)){
                    pq.remove();
                    pq.add(key);
                }
            }
        }
        int i=0;
        while(pq.size()!=0){
            ans[i] = pq.remove();
            i++;
        }
        return ans;
    }
}
