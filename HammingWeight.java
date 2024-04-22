public class Solution {

    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n &= n - 1;
            ans++;
        }
        return ans;
    }

    public int hammingWeight1(int n) {
        /*
            i = i - ((i >>> 1) & 0x55555555);
            i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
            i = (i + (i >>> 4)) & 0x0f0f0f0f;
            i = i + (i >>> 8);
            i = i + (i >>> 16);
            return i & 0x3f;
        */
        return Integer.bitCount(n);
    }

    public int hammingWeight0(int n) {
        int a = 1;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += n & a;
            n >>>= 1;
        }
        return ans;
    }
}
