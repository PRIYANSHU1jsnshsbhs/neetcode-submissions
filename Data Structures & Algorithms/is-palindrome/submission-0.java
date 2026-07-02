class Solution {
    public boolean isPalindrome(String s) {
        String t = s;
        t = t.toLowerCase();
        int n = s.length();
        int l = 0;
        int e = n - 1;
        while (l <= e) {
            while (l < e && !Character.isLetterOrDigit(t.charAt(l))) l++;
            while (l < e && !Character.isLetterOrDigit(t.charAt(e))) e--;
            if (t.charAt(l) != t.charAt(e)) return false;
            l++;
            e--;
        }
        return true;
    }
}