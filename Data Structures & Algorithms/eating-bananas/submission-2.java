class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(mid, h, piles)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public boolean isValid(int rate, int h, int[] piles) {
        int time = 0;

        for (int pile : piles) {
            time += (pile + rate - 1) / rate;

            if (time > h) {
                return false;
            }
        }

        return true;
    }
}