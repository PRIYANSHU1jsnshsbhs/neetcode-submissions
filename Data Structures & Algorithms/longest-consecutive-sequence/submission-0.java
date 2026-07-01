class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums)
            pq.offer(num);

        int count = 1;
        int ans = 1;

        int prev = pq.poll();

        while (!pq.isEmpty()) {

            int curr = pq.poll();

            if (curr == prev)
                continue;                  // Ignore duplicates

            if (curr == prev + 1)
                count++;
            else
                count = 1;

            ans = Math.max(ans, count);
            prev = curr;
        }

        return ans;
    }
}