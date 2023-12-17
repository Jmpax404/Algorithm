import java.util.*;

public class Solution {


    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int mapSize = n * n + 1;
        int[] rows = new int[mapSize];
        int rowIndex = 1;
        int endRow = n % 2;
        for (int i = n - 1; i >= endRow; ) {
            for (int k = 0; k < n; k++) {
                rows[rowIndex++] = board[i][k];
            }
            i--;
            for (int k = n - 1; k >= 0; k--) {
                rows[rowIndex++] = board[i][k];
            }
            i--;
        }
        if (endRow == 1) {
            for (int k = 0; k < n; k++) {
                rows[rowIndex++] = board[0][k];
            }
        }
        int[] queue = new int[1000];
        boolean[] visited = new boolean[mapSize];
        int qs = -1, qe = -1;
        queue[++qs] = 1;
        visited[1] = true;
        int step = 0;
        while (qs != qe) {
            step++;
            int end = qs;
            for (int j = qe + 1, nSquare = n * n; j <= end; j++) {
                int cur = queue[++qe];
                for (int i = 1; i <= 6; i++) {
                    int next = cur + i;
                    if (next > nSquare) {
                        break;
                    }
                    if (rows[next] != -1) {
                        next = rows[next];
                    }
                    if (next == nSquare) {
                        return step;
                    }
                    if (!visited[next]) {
                        queue[++qs] = next;
                    }
                    visited[next] = true;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[][] board =
                {
                        {-1, -1, -1, -1, -1, -1},
                        {-1, -1, -1, -1, -1, -1},
                        {-1, -1, -1, -1, -1, -1},
                        {-1, 35, -1, -1, 13, -1},
                        {-1, -1, -1, -1, -1, -1},
                        {-1, 15, -1, -1, -1, -1}
                };
        System.out.println(new Solution().snakesAndLadders(board));


    }
}