public class Solution {

    public int rob(int[] nums) {//滚动数组
        int n = nums.length;
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < n; i++) {
            c = Math.max(nums[i] + a, b);
            a = b;
            b = c;
        }
        return c;
    }

    public int rob1(int[] nums) {// 考虑到每个位置能够直接确定之前的结果 => 1维动态规划
        int n = nums.length;
        int[] dp = new int[n + 2];// 0, 0, x
        for (int i = 0; i < n; i++) {
            dp[i + 2] = Math.max(nums[i] + dp[i], dp[i + 1]);
        }
        return dp[n + 1];
    }

    public int rob0(int[] nums) {// 取 或者 不取
        int n = nums.length;
        int[][] dp = new int[n][2];


        dp[0][0] = 0;
        dp[0][1] = nums[0];


        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    //纯DFS，可以发现剪纸，进一步发现每层可以固定结果，为：取 或者 不取
}
