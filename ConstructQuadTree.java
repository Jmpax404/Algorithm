// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};


public class Solution {
    public Node construct(int[][] grid) {
        int end = grid.length - 1;
        return construct(grid, 0, end, 0, end);
    }

    private Node construct(int[][] grid, int a, int b, int c, int d) {
        if (a == b) {//at the same time, c==d
            return new Node(grid[a][c] == 1, true);
        }
        int xh = (a + b) / 2;
        int yh = (c + d) / 2;
        Node topLeft = construct(grid, a, xh, c, yh);
        Node topRight = construct(grid, a, xh, yh + 1, d);
        Node bottomLeft = construct(grid, xh + 1, b, c, yh);
        Node bottomRight = construct(grid, xh + 1, b, yh + 1, d);
        boolean isSame = topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
                topLeft.val == topRight.val &&
                topLeft.val == bottomLeft.val &&
                topLeft.val == bottomRight.val;
        if (isSame) {
            return new Node(topLeft.val, true, null, null, null, null);
        } else {
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0}
        };
        Node node = new Solution().construct(grid);
        System.out.println(node);
    }
}
