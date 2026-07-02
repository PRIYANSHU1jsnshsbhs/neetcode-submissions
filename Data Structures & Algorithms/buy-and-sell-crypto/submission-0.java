class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int i = 0;
        int j = Integer.MAX_VALUE;
        for (i = 0; i < n; i++) {
            j = Math.min(j, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - j);
        } 
        return maxProfit;
    }
}
