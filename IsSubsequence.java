class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();
        int i = 0, cn = cs.length;
        for (int j = 0, tn = ts.length; i < cn && j < tn; j++) {
            i = cs[i] == ts[j] ? i + 1 : i;
        }
        return i == cn;
    }
}