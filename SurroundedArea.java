import java.util.*;

public class Solution {

    class Coo {
        int x;
        int y;

        public Coo(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void handle(char[][] board, int i, int j, int[][] status) {
        int m = board.length;
        int n = board[0].length;
        if (board[i][j] == 'O' && status[i][j] == 0) {
            Deque<Coo> stack = new ArrayDeque<>();
            stack.push(new Coo(i, j));
            while (!stack.isEmpty()) {
                Coo pointNow = stack.pop();
                int x = pointNow.x;
                int y = pointNow.y;
                status[x][y] = 1;
                if (y - 1 >= 0 && board[x][y - 1] == 'O' && status[x][y - 1] == 0) {
                    stack.push(new Coo(x, y - 1));
                }
                if (x - 1 >= 0 && board[x - 1][y] == 'O' && status[x - 1][y] == 0) {
                    stack.push(new Coo(x - 1, y));
                }
                if (y + 1 < n && board[x][y + 1] == 'O' && status[x][y + 1] == 0) {
                    stack.push(new Coo(x, y + 1));
                }
                if (x + 1 < m && board[x + 1][y] == 'O' && status[x + 1][y] == 0) {
                    stack.push(new Coo(x + 1, y));
                }
            }
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] status = new int[m][n];
        for (int j = 0; j < n; j++) {
            handle(board, 0, j, status);
            handle(board, m - 1, j, status);
        }
        for (int i = 1; i < m - 1; i++) {
            handle(board, i, 0, status);
            handle(board, i, n - 1, status);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && status[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
