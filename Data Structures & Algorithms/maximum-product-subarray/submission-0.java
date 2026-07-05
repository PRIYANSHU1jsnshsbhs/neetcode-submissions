class Solution {
    public int maxProduct(int[] nums) {
        int leftProd = 1;
        int rightProd = 1;
        int n = nums.length;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            leftProd = leftProd == 0 ? 1 : leftProd;
            rightProd = rightProd == 0 ? 1 : rightProd;
            leftProd *= nums[i];
            rightProd *= nums[n-i-1];
            maxValue = Math.max(maxValue, Math.max(leftProd, rightProd));
        }
        return maxValue;
    }
}
