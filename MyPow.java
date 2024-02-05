class Solution {

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul2(x, n) : 1 / quickMul2(x, -N);
    }

    private double quickMul2(double x, long N) {
        double ans = 1;
        double t = x;
        while (N > 0) {
            long leave = N % 2;
            if (leave == 1) {
                ans *= t;
            }
            t *= t;
            N /= 2;
        }
        return ans;
    }

    public double myPow1(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, n) : 1 / quickMul(x, -N);
    }

    private double quickMul(double x, long N) {
        if (N == 0) {
            return 1;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow0(double x, int n) {
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        } else if (x == -1) {
            return -2 * (n % 2) + 1;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;//nearly
            } else {
                n = -n;
            }
        }
        double ans = x;
        for (int i = 1; i < n; i++) {// 复杂度太高，超时
            ans *= x;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2, -2147483648));
    }
}