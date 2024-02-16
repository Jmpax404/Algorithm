public class Solution {

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        int[] dp = new int[m + 1];
        for (int j = 1; j <= m; j++) {
            dp[j] = matrix[0][j - 1] - '0';
            max = Math.max(dp[j], max);
        }
        for (int i = 1; i < n; i++) {
            int west = 0, westnorth = 0;
            for (int j = 1; j <= m; j++) {
                if (matrix[i][j - 1] == '1') {
                    int t = Math.min(Math.min(dp[j], westnorth), west) + 1;
                    westnorth = dp[j];
                    dp[j] = t;
                    west = dp[j];
                    max = Math.max(west, max);
                } else {
                    westnorth = dp[j];
                    west = dp[j] = 0;
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        new Solution().maximalSquare(new char[][]{
                {'1', '0', '1', '0'},
                {'1', '0', '1', '1'},
                {'1', '0', '1', '1'},
                {'1', '1', '1', '1'}
        });
    }

    public int maximalSquare0(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int end = Math.min(n - i, m - j);
                int k = 0;
                for (; k < end; k++) {
                    boolean isSquare = true;
                    if (matrix[i + k][j + k] != '1') {
                        break;
                    }
                    for (int l = 0; l < k; l++) {
                        if (matrix[i + k][j + l] != '1') {
                            isSquare = false;
                            break;
                        }
                    }
                    if (!isSquare) {
                        break;
                    }
                    for (int l = 0; l < k; l++) {
                        if (matrix[i + l][j + k] != '1') {
                            isSquare = false;
                            break;
                        }
                    }
                    if (!isSquare) {
                        break;
                    }
                }
                if (k > max) {
                    max = k;
                }
            }
        }
        return max * max;
    }
}
