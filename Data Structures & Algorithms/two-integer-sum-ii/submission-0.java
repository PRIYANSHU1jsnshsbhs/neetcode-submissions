class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int e = numbers.length - 1;
        while (l < e) {
            int total = numbers[l] + numbers[e];
            if (total == target)
                return new int[]{l + 1, e + 1};
            else if (total < target)
                l++;
            else
                e--;
        }
        return new int[]{};
    }
}