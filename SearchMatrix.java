public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int endRow = findFirstGreaterRow(matrix, target) - 1;
        if (endRow == -1) {
            return false;
        }
        int[] nums = matrix[endRow];

        int i = 0;
        int j = matrix[0].length - 1;

        while (i <= j) {
            int mid = (i + j) / 2;
            if (matrix[endRow][mid] == target) {
                return true;
            } else if (matrix[endRow][mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return false;
    }

    private int findFirstGreaterRow(int[][] matrix, int target) {
        int m = matrix.length;

        int i = 0;
        int j = m - 1;

        while (i < j) {
            int mid = (i + j) / 2;
            if (matrix[mid][0] > target) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        // 最后一个是否需要要求需要特判
        if (matrix[j][0] > target) {
            return j;
        } else {
            return m;
        }
    }
}
