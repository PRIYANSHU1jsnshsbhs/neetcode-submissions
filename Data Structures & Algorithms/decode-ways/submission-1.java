// class Solution {
//     public int numDecodings(String s) {
//         int dp[] = new int[s.length()];
//         Arrays.fill(dp, -1);
//         return helper(s, 0, dp);
//     }
//     public int helper(String s, int i, int dp[]) {
//         if (i == s.length()) return 1;
//         if (s.charAt(i) == '0') return 0;
//         if (dp[i] != -1) return dp[i];
//         int one = helper(s, i + 1, dp);
//         int two = 0;
//         if (i + 1 < s.length()) {
//             int t = Integer.parseInt(s.substring(i, i + 2));
//             if (t >= 10 && t <= 26) {
//                 two = helper(s, i + 2, dp);
//             }
//         }
//         return dp[i] = one + two;
//     }
// }

class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        // dp[i] = number of ways to decode the substring starting at index i
        int[] dp = new int[n + 1];

        // Base case:
        // If we've reached the end of the string, we've found one valid decoding.
        dp[n] = 1;

        // Fill the table from right to left because dp[i] depends on
        // dp[i + 1] and dp[i + 2].
        for (int i = n - 1; i >= 0; i--) {

            // Strings starting with '0' cannot be decoded.
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            // Take one digit.
            dp[i] = dp[i + 1];

            // Take two digits if they form a valid number (10 to 26).
            if (i + 1 < n) {
                int num = Integer.parseInt(s.substring(i, i + 2));

                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        // Number of ways to decode the entire string.
        return dp[0];
    }
}