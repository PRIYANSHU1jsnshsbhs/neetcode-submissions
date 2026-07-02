class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int i = 0;
        int j = n - 1;
        int sum = 0;

        while (i < j) {
            int temp = (j - i) * Math.min(heights[i], heights[j]);
            sum = Math.max(sum, temp);
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }

        return sum;
    }
}
