class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0; 
        int j = 0;
        int maxValue = 0;
        Set<Character> set = new HashSet<>();
        // if (s.length() == 0) return 0;
        while (j < n) {
            while (set.size() != j - i + 1 && set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            maxValue = Math.max(maxValue, j-i+1);
            j++;
        }
        return maxValue;
    }
}
