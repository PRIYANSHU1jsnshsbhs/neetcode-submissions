class Solution {

    public String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();

        for (String s : strs) {
            ans.append(s.length()).append("#").append(s);
        }

        return ans.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < str.length();) {

            int j;
            for (j = i; str.charAt(j) != '#'; j++);

            int len = Integer.parseInt(str.substring(i, j));
            ans.add(str.substring(j + 1, j + 1 + len));

            i = j + 1 + len;
        }

        return ans;
    }
}