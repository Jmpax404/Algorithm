import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {//20240726
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);//为啥不直接初始化为 int 型的最大值 Integer.MAX_VALUE 呢？因为后面有 dp[i - coin] + 1，这就会导致整型溢出。
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = amount + 1;
            for (int coin : coins) {
                int t = i - coin;
                if (t >= 0 && dp[t] >= 0) {
                    min = Math.min(min, dp[t] + 1);
                }

            }
            dp[i] = min == amount + 1 ? -1 : min;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        new Solution().coinChange(new int[]{1, 2, 5}, 11);
    }
}

class Solution0 {

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -666);        // 备忘录初始化为一个不会被取到的特殊值，代表还未被计算


        return traverse(coins, amount, dp);
    }

    private int traverse(int[] coins, int amount, int[] dp) {
        if (amount < 0) {
            return -1;
        } else if (amount == 0) {
            return 0;
        }

        // 查备忘录，防止重复计算。
        // 备忘录放在前面，而不是循环里
        if (dp[amount] != -666) {
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0, end = coins.length; i < end; i++) {
            int t = traverse(coins, amount - coins[i], dp);
            if (t == -1) {
                continue;
            }

            min = Math.min(min, t + 1);
        }
        int res = min == Integer.MAX_VALUE ? -1 : min;
        dp[amount] = res;
        return res;
    }
}


public class Solution {//20240311

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
