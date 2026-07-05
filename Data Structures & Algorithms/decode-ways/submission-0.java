class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp);
    }
    public int helper(String s, int i, int dp[]) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (dp[i] != -1) return dp[i];
        int one = helper(s, i + 1, dp);
        int two = 0;
        if (i + 1 < s.length()) {
            int t = Integer.parseInt(s.substring(i, i + 2));
            if (t >= 10 && t <= 26) {
                two = helper(s, i + 2, dp);
            }
        }
        return dp[i] = one + two;
    }
}
