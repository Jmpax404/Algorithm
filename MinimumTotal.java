import java.util.Arrays;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {//倒着来
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {//兼容了最后一行
            List<Integer> list = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + list.get(j);
            }
        }
        return dp[0];
    }


    public int minimumTotal0(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            List<Integer> list = triangle.get(i);
            dp[i] = dp[i - 1] + list.get(i);//
            for (int j = i - 1; j >= 1; j--) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + list.get(j);
            }
            dp[0] = dp[0] + list.get(0);
        }
        return Arrays.stream(dp).min().getAsInt();
    }
}
