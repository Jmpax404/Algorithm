public class Solution {
    public int lengthOfLongestSubstring(String s) {
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