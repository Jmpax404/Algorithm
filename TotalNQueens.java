import java.util.HashSet;
import java.util.Set;

class Solution {
    private int MUSK_NUM;

    /*
核心两个位运算：
x & -x 代表 从后往前数第一个1保留，其它位全部为 0
x & (x - 1)  代表 从后往前数第一个1变为0，其余不动
 */
    public int totalNQueens(int n) {
        MUSK_NUM = (1 << n) - 1;
        return dfs(n, 0, 0, 0, 0);
    }

    private int dfs(int n, int row, int column, int slash, int backslash) {
        if (n == row) {
            return 1;
        }
        int count = 0;
        int canPlace = MUSK_NUM & ~(column | slash | backslash);
        while (canPlace > 0) {
            int position = canPlace & -canPlace;
            count += dfs(n, row + 1, column | position, (slash | position) << 1, (backslash | position) >>> 1);
            canPlace = canPlace & (canPlace - 1);
        }
        return count;
    }
}

class Solution2 {
    public int totalNQueens(int n) {
        Set<Integer> column = new HashSet<>();
        Set<Integer> slash = new HashSet<>();// /
        Set<Integer> backslash = new HashSet<>();// \
        return backtrack(n, 0, column, slash, backslash);
    }

    private int backtrack(int n, int row, Set<Integer> column, Set<Integer> slash, Set<Integer> backslash) {
        if (row == n) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (column.contains(i)) {
                continue;
            }
            int slashOffset = row - i;
            if (slash.contains(slashOffset)) {
                continue;
            }
            int backslashOffset = row + i;
            if (backslash.contains(backslashOffset)) {
                continue;
            }
            column.add(i);
            slash.add(slashOffset);
            backslash.add(backslashOffset);
            count += backtrack(n, row + 1, column, slash, backslash);
            backslash.remove(backslashOffset);
            slash.remove(slashOffset);
            column.remove(i);
        }
        return count;
    }
}


class Solution1 {
    private int count = 0;

    public int totalNQueens(int n) {
        dfs(new int[n], n, 0);
        return count;
    }

    private void dfs(int[] pos, int n, int row) {
        for (int k = 0; k < n; k++) {
            boolean isOccupied = false;
            for (int i = 0; i < row; i++) {
                if (pos[i] == k) {
                    isOccupied = true;
                    break;
                }
            }
            if (isOccupied) {
                continue;
            }
            for (int i = 0; i < row; i++) {
                if (Math.abs(row - i) == Math.abs(k - pos[i])) {
                    isOccupied = true;
                    break;
                }
            }
            if (isOccupied) {
                continue;
            }
            pos[row] = k;
            if (row == n - 1) {
                count++;
                return;
            }
            dfs(pos, n, row + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().totalNQueens(4));
    }
}
