class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Key = number, Value = its index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            // If complement already exists, we've found the pair
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Store current number and its index
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}