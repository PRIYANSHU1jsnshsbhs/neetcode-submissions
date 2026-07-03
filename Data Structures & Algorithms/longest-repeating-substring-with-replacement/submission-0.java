class Solution {
    public int characterReplacement(String s, int k) {

        int n = s.length();
        int i = 0;
        int j = 0;

        int[] freq = new int[26];
        int result = 0;

        while (j < n) {

            // CORRECTION 1:
            // Update frequency BEFORE calculating maxFreq.
            freq[s.charAt(j) - 'A']++;

            int maxFreq = 0;

            // CORRECTION 2:
            // Compute max frequency after including s[j].
            for (int p : freq)
                maxFreq = Math.max(maxFreq, p);

            while ((j - i + 1) - maxFreq > k) {

                // CORRECTION 3:
                // Remove the left character from the window.
                freq[s.charAt(i) - 'A']--;
                i++;

                // CORRECTION 4:
                // Since the window changed, recompute maxFreq.
                maxFreq = 0;
                for (int p : freq)
                    maxFreq = Math.max(maxFreq, p);
            }

            result = Math.max(result, j - i + 1);

            // CORRECTION 5:
            // Increment j AFTER all processing.
            // In your code, you incremented j first and then accessed s.charAt(j),
            // which could cause IndexOutOfBoundsException.
            j++;
        }

        return result;
    }
}