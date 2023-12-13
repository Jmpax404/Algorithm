public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                int a = 0b11;
                int pm = 6800;// 0b0110101001000000 {-1, -1, -1, 0, 1, 1, 1, 0}
                int pn = 425;// 0b0000011010100100 {-1, 0, 1, 1, 1, 0, -1, -1}
                for (int k = 0; k < 8; k++, pm >>= 2, pn >>= 2) {
                    int ti = i + (pm & a) - 1;
                    int tj = j + (pn & a) - 1;
                    if (ti >= 0 && ti < m && tj >= 0 && tj < n) {
                        count += ((board[ti][tj] & 1) == 1) ? 1 : 0;
                    }
                }
                if (board[i][j] == 1) {
                    if (count == 2 || count == 3) {
                        board[i][j] |= 2;
                    }
                } else {
                    if (count == 3) {
                        board[i][j] |= 2;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().gameOfLife(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}});
    }
}