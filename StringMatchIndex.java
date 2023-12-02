import java.util.Arrays;

class Solution {
    public int strStr(String haystack, String needle) {
        char[] hs = haystack.toCharArray();
        char[] ns = needle.toCharArray();
        int hn = hs.length;
        int nn = ns.length;
        int[] next = new int[nn];
        int prex = 0;
        int i = 1;
        next[0] = 0;
        while (i < nn) {
            if (ns[prex] == ns[i]) {
                next[i++] = ++prex;
            } else {
                if (prex == 0) {
                    next[i++] = 0;
                } else {
                    prex = next[prex - 1];
                }
            }
        }
        i = 0;
        int j = 0;
        while (i < hn) {
            if (hs[i] == ns[j]) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j - 1];
            }
            if (j == nn) {
                return i - j;
            }
        }
        return -1;
    }

    public int strStr0(String haystack, String needle) {
        char[] hs = haystack.toCharArray();
        char[] ns = needle.toCharArray();
        int hn = hs.length;
        int nn = ns.length;
        if (hn < nn) {
            return -1;
        }
        for (int i = 0; i <= hn - nn; i++) {
            boolean isEqual = true;
            for (int j = 0; j < ns.length; j++) {
                if (hs[i + j] != ns[j]) {
                    isEqual = false;
                    break;
                }
            }
            if (isEqual) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("mississippi", "issip"));
    }
}