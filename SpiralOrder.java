import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int x = 0;
        int y = -1;
        int i;
        int upMax = 0;
        int downMax = matrix.length;
        int leftMax = 0;
        int rightMax = matrix[0].length;
        //  list.add(matrix[0][0]);
        while (true) {
            // System.out.println("new time");
            if (y + 1 == rightMax) {
                break;
            }
            for (i = y + 1; i < rightMax; i++) {
                list.add(matrix[x][i]);
            }
            upMax++;
            y = i - 1;
            if (x + 1 == downMax) {
                break;
            }
            for (i = x + 1; i < downMax; i++) {
                list.add(matrix[i][y]);
            }
            rightMax--;
            x = i - 1;
            if (y - 1 == leftMax - 1) {
                break;
            }
            for (i = y - 1; i >= leftMax; i--) {
                list.add(matrix[x][i]);
            }
            downMax--;
            y = i + 1;
            if (x - 1 == upMax - 1) {
                break;
            }
            for (i = x - 1; i >= upMax; i--) {
                list.add(matrix[i][y]);
            }
            leftMax++;
            x = i + 1;
            // System.out.println(list);
        }

        //System.out.println(list);

        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}