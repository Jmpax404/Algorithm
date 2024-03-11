import java.util.Arrays;

public class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public int coinChange0(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int minCount = Integer.MAX_VALUE;
            for (int j = 0, len = coins.length; j < len; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] < minCount) {
                    minCount = dp[i - coins[j]];
                }
            }
            if (minCount == Integer.MAX_VALUE) {
                dp[i] = Integer.MAX_VALUE;
            } else {
                dp[i] = minCount + 1;
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{1, 2, 5}, 11));
    }
}

class Solution0 { //dfs + memo
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        int ans = findway(coins, amount);
        return ans;
    }

    private int findway(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != 0) {
            return memo[amount];
        } else {
            int minCount = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                int countOther = findway(coins, amount - coins[i]);
                if (countOther != -1 && countOther < minCount) {
                    minCount = countOther;
                }
            }
            if (minCount == Integer.MAX_VALUE) {
                memo[amount] = -1;
                return -1;
            } else {
                memo[amount] = minCount + 1;
                return memo[amount];
            }
        }
    }

}
