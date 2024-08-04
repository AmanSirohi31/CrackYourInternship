class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i], i);
        }
        for(int i=0; i<nums2.length; i++){
            while(!st.isEmpty() && nums2[i]>st.peek()){
                ans[map.get(st.pop())] = nums2[i]; 
            }
            if(map.containsKey(nums2[i]))st.push(nums2[i]);
        }
        while(!st.isEmpty()){
            ans[map.get(st.pop())] = -1;
        }
        return ans;
    }
}
