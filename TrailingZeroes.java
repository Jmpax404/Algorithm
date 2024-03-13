public class Solution {

    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public int trailingZeroes1(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int t = i;
            while (t > 0 && t % 5 == 0) {
                count++;
                t /= 5;
            }
        }
        return count;
    }

    public int trailingZeroes0(int n) {//wrong method 625时 不只有个位数有影响
        int leave = 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int t = leave * i;
            while (t % 10 == 0) {
                t /= 10;
                count++;
            }
            leave = t % 10;
        }
        return count;
    }
}
