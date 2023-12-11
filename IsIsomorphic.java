class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        int[] trans1 = new int[128];
        int[] trans2 = new int[128];
        for (int i = 0, n = ss.length; i < n; i++) {
            char sc = ss[i];
            char tc = ts[i];
            if (trans1[sc] != trans2[tc]) {
                return false;
            } else if (trans1[sc] == 0) {
                trans1[sc] = trans2[tc] = i + 1;
            }
        }
        return true;
    }

    public boolean isIsomorphic0(String s, String t) {
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        char[] hash1 = new char[128];
        char[] hash2 = new char[128];
        for (int i = 0; i < ss.length; i++) {
            char c1 = hash1[ss[i]];
            char c2 = hash2[ts[i]];
            if (c1 == 0 && c2 == 0) {
                hash1[ss[i]] = ts[i];
                hash2[ts[i]] = ss[i];
            } else {
                if (c1 != 0 && c1 != ts[i] || c2 != 0 && c2 != ss[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}