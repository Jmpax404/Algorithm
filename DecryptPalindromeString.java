import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cs = sc.nextLine().toCharArray();
        int n = cs.length;
        boolean[][] dp = new boolean[n][n];
        char[] rcs = new char[n];
        int[] ans = new int[n];
        rcs[0] = cs[0];
        dp[0][0] = true;
        ans[0] = 1;
        System.out.print(ans[0]);
        for (int i = 1; i < n; i++) {
            char rc = (char) ((cs[i] - 97 + ans[i - 1]) % 26 + 97);
            rcs[i] = rc;
            int count = 0;
            for (int j = 0; j <= i; j++) {
                if (rcs[j] == rcs[i]) {
                    if (i == j || j == i - 1) {
                        dp[j][i] = true;
                        count++;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                        count += dp[j][i] ? 1 : 0;
                    }
                } else {
                    dp[j][i] = false;
                }
            }
            ans[i] = ans[i - 1] + count;
            System.out.print(" " + ans[i]);
        }
        System.out.println();
    }

}