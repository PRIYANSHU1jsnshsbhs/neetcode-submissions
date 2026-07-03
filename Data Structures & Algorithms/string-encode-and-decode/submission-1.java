class Solution {

    public String encode(List<String> strs) {
        String ans = "";

        for (String s : strs) {
            ans += s.length() + "#" + s;
        }

        return ans;
    }

    public List<String> decode(String str) {
        int n = str.length();
        int i = 0;
        List<String> ans = new ArrayList<>();

        while (i < n) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));
            j++;

            ans.add(str.substring(j, j + len));
            i = j + len;
        }

        return ans;
    }
}