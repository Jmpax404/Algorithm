public class Solution {
    public int fib(int n) {
        int res = 0;
        for (int i = 0, left = -1, right = 1; i <= n; i++) {
            res = left + right;
            left = right;
            right = res;
        }
        return res;
    }

    public static void main(String[] args) {
        int fib = new Solution().fib(3);
        System.out.println(fib);
    }
}
