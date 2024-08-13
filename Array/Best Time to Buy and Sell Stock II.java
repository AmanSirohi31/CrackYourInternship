class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int prevMin = prices[0];
        for(int i=0; i<prices.length; i++){
            if(prevMin<=prices[i]){
                profit += prices[i]-prevMin;
            }
            prevMin = prices[i];
        }
        return profit;
    }
}
