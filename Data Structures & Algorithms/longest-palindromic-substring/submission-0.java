class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        if (n <= 1) return s;

        int start = 0;
        int maxLen = 1;

        for (int i = 0; i < n; i++) {

            // Odd length palindrome
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            int len = r - l - 1;
            if (len > maxLen) {
                maxLen = len;
                start = l + 1;
            }

            // Even length palindrome
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            len = r - l - 1;
            if (len > maxLen) {
                maxLen = len;
                start = l + 1;
            }
        }

        return s.substring(start, start + maxLen);
    }
}