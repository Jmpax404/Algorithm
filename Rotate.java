public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int row = n / 2;
        int col = (n + 1) / 2;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int t = matrix[i][j];
                int ni1 = n - i - 1;
                int nj1 = n - j - 1;
                matrix[i][j] = matrix[nj1][i];
                matrix[nj1][i] = matrix[ni1][nj1];
                matrix[ni1][nj1] = matrix[j][ni1];
                matrix[j][ni1] = t;
            }
        }
    }
}