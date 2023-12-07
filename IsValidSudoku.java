class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] spaces = new int[9];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int v = 1 << (c - '0');
                int spaceIndex;
                if ((rows[i] & v) != 0 || (cols[j] & v) != 0 ||
                        (spaces[spaceIndex = i / 3 * 3 + j / 3] & v) != 0
                ) {
                    return false;
                }
                rows[i] |= v;
                cols[j] |= v;
                spaces[spaceIndex] |= v;
            }
        }
        return true;
    }

    public boolean isValidSudoku1(char[][] board) {
        int n = 9;
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][][] spaces = new boolean[3][3][10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int v = c - '0';
                if (rows[i][v] || cols[j][v] || spaces[i / 3][j / 3][v]) {
                    return false;
                }
                rows[i][v] = true;
                cols[j][v] = true;
                spaces[i / 3][j / 3][v] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}