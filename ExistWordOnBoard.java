public class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i <m; i++) {
            for (int j = 0; j < n; j++) {
                boolean result =  dfs(word.toCharArray(), 0, board, i, j, visited);
                if(result){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[] word, int index, char[][] board, int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        if (word[index] == board[x][y]) {
            if (index == word.length - 1) {
                return true;
            }
            visited[x][y] = true;
            boolean result=  dfs(word, index + 1, board, x, y + 1, visited) ||
                    dfs(word, index + 1, board, x + 1, y, visited) ||
                    dfs(word, index + 1, board, x, y - 1, visited) ||
                    dfs(word, index + 1, board, x - 1, y, visited);
            visited[x][y] = false;
            return result;
        }else {
            return false;
        }
    }
}
