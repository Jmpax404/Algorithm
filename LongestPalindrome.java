import java.util.Arrays;

public class Solution {
    public String longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[][] dp = new int[n][n];
        char preChar = cs[0];
        dp[0][0] = 1;
        int max = 1;
        int resStart = 0;
        for (int i = 1; i < n; i++) {
            dp[i][i] = 1;
            if (cs[i] == preChar) {
                dp[i - 1][i] = 2;
                if (max < 2) {
                    resStart = i - 1;
                    max++;
                }
            }
            preChar = cs[i];
        }
        for (int k = 2; k < n; k++) {
            for (int i = 0, end = n - k; i < end; i++) {
                if (cs[i] == cs[i + k] && dp[i + 1][i + k - 1] > 0) {
                    int t = dp[i][i + k] = dp[i + 1][i + k - 1] + 2;
                    if (t > max) {
                        max = t;
                        resStart = i;
                    }
                }
            }
        }
        return new String(cs, resStart, max);
    }

    public static void main(String[] args) {
        new Solution().longestPalindrome("aacabdkacaa");
    }
}