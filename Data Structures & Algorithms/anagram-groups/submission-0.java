class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // Key = sorted string, Value = list of its anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // Sort the characters to create a unique key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Create a new list if the key doesn't exist
            map.putIfAbsent(key, new ArrayList<>());

            // Add the original string to its anagram group
            map.get(key).add(str);
        }

        // Return all the grouped anagrams
        return new ArrayList<>(map.values());
    }
}