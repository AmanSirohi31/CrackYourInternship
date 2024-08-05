class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] pseArr = psee(arr);
        int[] nseArr = nse(arr);
        long total = 0;
        int mod = (int)Math.pow(10, 9)+7;
        for(int i=0; i<arr.length; i++){
            int p = pseArr[i];
            int n = nseArr[i];
            long count = (long)((i-p) * (n-i))*arr[i];
            total = (total + count%mod)%mod;
        }
        return (int)total;

    }
    private int[] psee(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                ans[st.pop()] = i;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            ans[st.pop()] = -1;
        }
        return ans;
    }
    private int[] nse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                ans[st.pop()] = i;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            ans[st.pop()] = arr.length;
        }
        return ans;
    }
}
