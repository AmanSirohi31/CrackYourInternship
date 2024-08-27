class Solution {
	public int helper(int i, int n, int[] arr){
		if(i==n){
			return 1;
		}
		if(i>n){
			return 0;
		}
		if(arr[i] != -1){
			return arr[i];
		}
		int rr1 = helper(i+1,n,arr);
		int rr2 = helper(i+2,n,arr);
		int ans = rr1+rr2;
		arr[i]=ans;
		return ans;
	}
	public int climbStairs(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp,-1);
		return helper(0,n,dp);
	}
}
