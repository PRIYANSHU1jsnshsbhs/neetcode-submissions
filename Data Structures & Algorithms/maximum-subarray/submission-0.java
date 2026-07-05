class Solution {
    public int maxSubArray(int[] nums) {

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int num : nums) {

            // Extend the current subarray
            currSum += num;

            // Update the maximum sum found so far
            maxSum = Math.max(maxSum, currSum);

            // If current sum becomes negative, discard it
            if (currSum < 0)
                currSum = 0;
        }

        return maxSum;
    }
}