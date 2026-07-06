class TimeMap {

    class Pair {
        int ts;
        String val;

        Pair(int ts, String val) {
            this.ts = ts;
            this.val = val;
        }
    }

    HashMap<String, ArrayList<Pair>> h;

    public TimeMap() {
        h = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        h.putIfAbsent(key, new ArrayList<>());
        h.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!h.containsKey(key)) return "";
        ArrayList<Pair> temp = h.get(key);
        int l = 0;
        int r = temp.size() - 1;
        String ans = "";
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (temp.get(mid).ts <= timestamp) {
                ans = temp.get(mid).val;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}