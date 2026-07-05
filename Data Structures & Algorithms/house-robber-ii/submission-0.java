class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int ans1 = helper(nums, 0, n - 2, dp1);
        int ans2 = helper(nums, 1, n - 1, dp2);

        return Math.max(ans1, ans2);
    }

    public int helper(int[] nums, int start, int end, int[] dp) {
        if (end < start) return 0;
        if (end == start) return nums[start];

        if (dp[end] != -1) return dp[end];

        int pick = nums[end] + helper(nums, start, end - 2, dp);
        int notPick = helper(nums, start, end - 1, dp);

        return dp[end] = Math.max(pick, notPick);
    }
}