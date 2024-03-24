import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> findWords = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        int[] charStat = new int[26];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                charStat[board[i][j] - 'a']++;
            }
        }
        for (String word : words) {
            char[] cs = word.toCharArray();
            boolean[][] visited = new boolean[m][n];
            boolean[] findFlagP = new boolean[1];
            int cn = cs.length;
            boolean reverse = false;
            if (charStat[cs[0] - 'a'] > charStat[cs[cn - 1] - 'a']) {
                reverse = true;
                reverseChars(cs, cn);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (findFlagP[0]) {
                        break;
                    }
                    if (board[i][j] == cs[0]) {//delete
                        dfs(board, m, n, cs, cn, 0, i, j, visited, findWords, findFlagP, reverse);
                    }
                }
                if (findFlagP[0]) {
                    break;
                }
            }
        }
        return findWords;
    }

    private void reverseChars(char[] cs, int cn) {
        for (int i = 0, j = cn - 1; i < j; i++, j--) {
            char t = cs[i];
            cs[i] = cs[j];
            cs[j] = t;
        }
    }

    private void dfs(char[][] board, int m, int n, char[] cs, int cn, int index, int i, int j,
                     boolean[][] visited, List<String> findWords, boolean[] findFlagP, boolean reverse) {
        if (findFlagP[0]) {
            return;
        }
        if (index == cn) {
            if (reverse) {
                reverseChars(cs, cn);
            }
            findWords.add(new String(cs));
            findFlagP[0] = true;
            return;
        }
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (visited[i][j] || board[i][j] != cs[index]) {
            return;
        }
        visited[i][j] = true;
        dfs(board, m, n, cs, cn, index + 1, i - 1, j, visited, findWords, findFlagP, reverse);
        dfs(board, m, n, cs, cn, index + 1, i, j - 1, visited, findWords, findFlagP, reverse);
        dfs(board, m, n, cs, cn, index + 1, i + 1, j, visited, findWords, findFlagP, reverse);
        dfs(board, m, n, cs, cn, index + 1, i, j + 1, visited, findWords, findFlagP, reverse);
        visited[i][j] = false;
    }
}

