public class Solution {

    public int lengthOfLongestSubstring(String s) {//20240721
        char[] cs = s.toCharArray();
        int n = cs.length;
        boolean[] set = new boolean[128];
        int i = 0, j = 0;
        int max = 0;
        while (i < n) {
            char c = cs[i];
            i++;
            if (!set[c]) {
                set[c] = true;
            } else {
                max = Math.max(max, i - j - 1);
                char cj;
                while ((cj = cs[j++]) != c) {
                    set[cj] = false;
                }
            }
        }
        max = Math.max(max, i - j);
        return max;
    }

    public int lengthOfLongestSubstring(String s) {//20231210
        int i = 0;
        char[] cs = s.toCharArray();
        int n = s.length();
        int[] hash = new int[128];
        int max = 0;
        for (int j = 0; j < n; j++) {
            char c = cs[j];
            int t = hash[c];
            int d;
            if (t != 0) {
                while (i < t) {
                    hash[cs[i++]] = 0;
                }
                hash[c] = j + 1;
            } else {
                hash[c] = j + 1;
                if ((d = j - i + 1) > max) {
                    max = d;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
}