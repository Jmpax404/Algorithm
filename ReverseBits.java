public class Solution {
    private final static int M1 = 0x55555555;//01010101010101...
    private final static int M2 = 0x33333333;//001100110011....
    private final static int M4 = 0x0f0f0f0f;//00001111....
    private final static int M8 = 0x00ff00ff;//000000001111111....

    public int reverseBits(int n) {
        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;
        return n >>> 16 | n << 16;
    }

    public int reverseBits2(int n) {
        return Integer.reverse(n);
    }

    public int reverseBits1(int n) {
        int rev = 0;
        for (int i = 0; i < 32; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }

    public int reverseBits0(int n) {
        int ans = 0;
        int a = 1;
        for (int i = 0; i < 16; i++, a <<= 1) {
            ans |= (a & n) << (31 - i * 2);
        }
        for (int i = 16; i < 32; i++, a <<= 1) {
            ans |= (a & n) >>> (i * 2 - 31);
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().reverseBits(0b00000010100101000001111010011100);
    }
}
