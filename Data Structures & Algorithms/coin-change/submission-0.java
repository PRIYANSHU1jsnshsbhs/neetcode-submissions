class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = helper(coins, amount, coins.length);
        if (ans == Integer.MAX_VALUE - 1) {
            return -1;
        }
        return ans;
    }

    public int helper(int[] coins, int amount, int n) {
        if (amount == 0) {
            return 0;
        }
        if (n == 0) {
            return Integer.MAX_VALUE - 1;
        }
        if (coins[n - 1] <= amount) {
            int pick = 1 + helper(coins, amount - coins[n - 1], n);
            int notPick = helper(coins, amount, n - 1);
            return Math.min(pick, notPick);
        } else {
            return helper(coins, amount, n - 1);
        }
    }
}