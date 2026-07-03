class Solution {

    public String encode(List<String> strs) {
        String ans = "";

        for (String s : strs) {
            ans += s.length() + "#" + s;
        }

        return ans;
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < str.length();) {
            int hash = str.indexOf('#', i);

            int len = Integer.parseInt(str.substring(i, hash));
            ans.add(str.substring(hash + 1, hash + 1 + len));

            i = hash + 1 + len;
        }

        return ans;
    }
}