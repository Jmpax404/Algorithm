import java.util.Arrays;

public class Solution {

    public int maxStudents(char[][] seats) {
        int m = seats.length;
        int n = seats[0].length;
        int[] lines = new int[m];
        for (int i = 0; i < m; i++) {
            int temp = 0;
            for (int j = n - 1; j >= 0; j--) {
                temp <<= 1;
                if (seats[i][j] == '.') {
                    temp = temp | 1;
                }
            }
            lines[i] = temp;
        }
        //记忆化
        int[][] memo = new int[m][1 << n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(lines, m - 1, lines[m - 1], memo);
    }

    private int dfs(int[] lines, int level, int line, int[][] memo) {
        if (memo[level][line] != -1) {
            return memo[level][line];
        }
        if (level == 0) {//第0层最多不相邻1的个数
            if (line == 0) {//递归中的递归
                return memo[0][0] = 0;
            }
            int lowBit = line & -line;
            int mask = lowBit << 1 | lowBit;// lb * 3
            return memo[level][line] = dfs(lines, 0, line & ~mask, memo) + 1;
        }
        int maxCount = dfs(lines, level - 1, lines[level - 1], memo);
        for (int curLine = line; curLine > 0; curLine = (curLine - 1) & line) {
            if ((curLine & curLine >> 1) == 0) {//当前座位是否满足
                int preCantSeat = curLine >> 1 | curLine << 1;
                int preLine = lines[level - 1] & ~preCantSeat;
                int preCount = dfs(lines, level - 1, preLine, memo);

                //统计当前层1的个数 Integer.bitCount(s)
                int i = curLine;
                int curCount = 0;
                while (i > 0) {
                    curCount += i & 1;
                    i >>>= 1;
                }
                maxCount = Math.max(maxCount, preCount + curCount);
            }
        }
        return memo[level][line] = maxCount;
    }


    public static void main(String[] args) {
        new Solution().maxStudents(new char[][]{{'#', '.', '#', '#', '.', '#'}, {'.', '#', '#', '#', '#', '.'}, {'#', '.', '#', '#', '.', '#'},});
        //Integer.bitCount(s);
    }

}
