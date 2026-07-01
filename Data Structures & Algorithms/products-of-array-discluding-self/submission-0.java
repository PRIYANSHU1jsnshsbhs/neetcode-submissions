class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] prev = new int[n];
        int[] next = new int[n];
        int[] ans = new int[n];

        Arrays.fill(prev, 1);
        Arrays.fill(next, 1);

        // Prefix products
        for (int i = 1; i < n; i++) {
            prev[i] = prev[i - 1] * nums[i - 1];
        }

        // Suffix products
        for (int i = n - 2; i >= 0; i--) {
            next[i] = next[i + 1] * nums[i + 1];
        }

        // Multiply prefix and suffix
        for (int i = 0; i < n; i++) {
            ans[i] = prev[i] * next[i];
        }

        return ans;
    }
}