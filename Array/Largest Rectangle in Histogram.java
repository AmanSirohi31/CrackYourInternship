class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i=0; i<heights.length; i++){
            int cur = heights[i];
            while(!st.isEmpty() && heights[st.peek()]>cur){
                int idx = st.pop();
                int pse = st.isEmpty() ? -1 : st.peek();
                int nse = i;
                maxArea = Math.max(maxArea, heights[idx]*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int idx = st.pop();
            int nse = heights.length;
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, heights[idx]*(nse-pse-1));
        }
        return maxArea;
    }
}
