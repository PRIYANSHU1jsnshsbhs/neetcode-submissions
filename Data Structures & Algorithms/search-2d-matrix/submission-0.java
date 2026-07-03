class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int j = m * n - 1;
        while (i <= j) {
            int mid = i + (j - i)/2;
            int x_mid = mid / n;
            int y_mid = mid % n;
            if (matrix[x_mid][y_mid] == target) return true;
            else if (matrix[x_mid][y_mid] > target) j = mid - 1;
            else i = mid + 1;
        }
        return false;
    }
}
