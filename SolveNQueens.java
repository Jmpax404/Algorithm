import java.util.*;

public class Solution {
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        int[][] board = new int[n][n];
        traverse(n, 0, board);
        return res;
    }

    private void traverse(int n, int row, int[][] board) {
        if (row == n) {
            List<String> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j] == 1 ? 'Q' : '.');
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }

        for (int col = 0; col < n; col++) {

            boolean pass = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1) {
                        if (j == col || Math.abs(i - row) == Math.abs(j - col)) {
                            pass = false;
                            break;
                        }

                    }
                }
                if (!pass) {
                    break;
                }
            }


            if (!pass) {
                continue;
            }

            board[row][col] = 1;
            traverse(n, row + 1, board);
            board[row][col] = 0;
        }

    }
}