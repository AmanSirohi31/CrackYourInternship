class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[temperatures.length];
        int idx = 0;
        while(idx<temperatures.length){
            if(!st.isEmpty() && temperatures[st.peek()]<temperatures[idx]){
                int i = st.pop();
                ans[i] = idx-i;
            }
            else{
                st.push(idx);
                idx++;
            }
        }
        return ans;
    }
}
