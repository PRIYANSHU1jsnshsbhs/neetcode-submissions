class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(helper(cost, n - 1, dp), helper(cost, n - 2, dp));
    }
    public int helper(int cost[], int n, int[] dp) {
        if (n == 1 || n == 0) return cost[n];
        if (n < 0) return 0;
        if (dp[n] != -1) return dp[n];
        int s1 = helper(cost, n - 1, dp);
        int s2 = helper(cost, n - 2, dp);
        int minCost = Math.min(s1, s2);
        return dp[n] = cost[n] + minCost;
    }
}
