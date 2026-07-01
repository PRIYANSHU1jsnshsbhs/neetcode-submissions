class Solution {
    public boolean hasDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            // If already present, duplicate found
            if (set.contains(num))
                return true;

            // Otherwise, add it to the set
            set.add(num);
        }

        // No duplicates found
        return false;
    }
}