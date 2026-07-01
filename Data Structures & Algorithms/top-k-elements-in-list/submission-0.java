class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;

        List<Integer>[] buckSort = new ArrayList[n + 1];
        HashMap<Integer, Integer> h = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        // Frequency should start from 0, not 1
        for (int num : nums) {
            h.put(num, h.getOrDefault(num, 0) + 1);
        }

        // Iterate over entrySet(), not the HashMap directly
        for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
            int freq = entry.getValue();

            // Initialize bucket before adding
            if (buckSort[freq] == null)
                buckSort[freq] = new ArrayList<>();

            buckSort[freq].add(entry.getKey());
        }

        // Traverse from highest frequency to lowest
        // Stop once k elements have been collected
        for (int i = n; i >= 0 && ans.size() < k; i--) {

            // Skip empty buckets
            if (buckSort[i] != null) {

                for (int num : buckSort[i]) {
                    ans.add(num);

                    // Don't add more than k elements
                    if (ans.size() == k)
                        break;
                }
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
