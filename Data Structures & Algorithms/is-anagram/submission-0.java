class Solution {
    public boolean isAnagram(String s, String t) {

        // If lengths differ, they can't be anagrams
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of each character in s
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Decrease frequency using characters from t
        for (char ch : t.toCharArray()) {

            if (!map.containsKey(ch))
                return false;

            map.put(ch, map.get(ch) - 1);

            // Remove character if its count becomes 0
            if (map.get(ch) == 0)
                map.remove(ch);
        }

        // Map should be empty if both strings are anagrams
        return map.isEmpty();
    }
}