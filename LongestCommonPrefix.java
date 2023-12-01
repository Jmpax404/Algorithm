class Solution {
    public String longestCommonPrefix(String[] strs) {
        int strsLen = strs.length;
        int end = strs[0].length();
        for(int k=0;k<end;k++) {
            char c = strs[0].charAt(k);
            for (int i = 1; i < strsLen; i++) {
                if (k == strs[i].length() || strs[i].charAt(k) != c) {
                    return strs[0].substring(0, k);
                }
            }
        }
        return strs[0];
    }
}