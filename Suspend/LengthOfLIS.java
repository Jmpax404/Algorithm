import java.util.Map;

public class Solution {
    //10,9,2,5,3,7,101,18
    // 2 2  4  3 3 2  1  1
    // last to first
    // find first greater
    // 10 9  100 50 24 60 100 30 20 12 14 11
    //  3  2(3)   1  1  1  1  2   1
    public int lengthOfLIS(int[] nums) {// o(n^2), 从后往前，找到以i开头的dp，方法是找到后面最大的dp再+1，最后统计dp最大的。
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 1;
        int maxRes = 1;
        for (int i = n - 2; i >= 0; i--) {
            int maxLast = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    maxLast = Math.max(maxLast, dp[j]);
                }
            }
            dp[i] = maxLast + 1;
            maxRes = Math.max(maxRes, dp[i]);
        }
        return maxRes;
    }
}
