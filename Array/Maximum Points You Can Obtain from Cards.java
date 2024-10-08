class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lSum = 0;
        int rSum = 0;
        int sum = 0;
        for(int i=0; i<k; i++){
            lSum+=cardPoints[i];
        }
        sum = lSum;
        for(int i=0; i<k; i++){
            lSum-=cardPoints[k-1-i];
            rSum+=cardPoints[n-1-i];
            sum = Math.max(sum, lSum+rSum);
        }
        return sum;
    }
}
