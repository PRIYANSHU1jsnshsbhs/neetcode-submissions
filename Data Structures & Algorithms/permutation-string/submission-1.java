class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int i = 0;
        int j = 0;

        HashMap<Character, Integer> h = new HashMap<>();

        for (char p : s1.toCharArray()) {
            h.put(p, h.getOrDefault(p, 0) + 1);
        }

        while (j < n2) {
            if (h.containsKey(s2.charAt(j))) {
                h.put(s2.charAt(j), h.get(s2.charAt(j)) - 1);
            }
            if (j - i + 1 == n1) {
                boolean changed = true;
                for (int l : h.values()) {
                    if (l != 0)
                        changed = false;
                }
                if (changed)
                    return true;
                if (h.containsKey(s2.charAt(i))) {
                    h.put(s2.charAt(i), h.get(s2.charAt(i)) + 1);
                }
                i++;
            }
            if (j - i + 1 > n1) {
                if (h.containsKey(s2.charAt(i))) {
                    h.put(s2.charAt(i), h.get(s2.charAt(i)) + 1);
                }
                i++;
            }
            j++;
        }
        return false;
    }
}
