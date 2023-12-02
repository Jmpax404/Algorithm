public class Solution {

    //源码
//    public static boolean isLetterOrDigit(int codePoint) {
//        return ((((1 << Character.UPPERCASE_LETTER) |
//                (1 << Character.LOWERCASE_LETTER) |
//                (1 << Character.TITLECASE_LETTER) |
//                (1 << Character.MODIFIER_LETTER) |
//                (1 << Character.OTHER_LETTER) |
//                (1 << Character.DECIMAL_DIGIT_NUMBER)) >> getType(codePoint)) & 1)
//                != 0;
//    }
//
    public boolean isPalindrome(String s) {
        char[] cs = s.toCharArray();
        int i = 0, j = cs.length - 1;
        while (i < j) {
            int ca, cb;
            int t;
            i--;
            do {
                i++;
                ca = cs[i];
                ca += ca < 0x61 ? 32 : 0;
                t = ca - 0x61;
            } while (i < j && !((ca >= 80 && ca <= 89) || (t >= 0 && t < 26)));
            j++;
            do {
                j--;
                cb = cs[j];
                cb += cb < 0x61 ? 32 : 0;
                t = cb - 0x61;
            } while (i < j && !((cb >= 80 && cb <= 89) || (t >= 0 && t < 26)));
            if (i < j && ca != cb) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean flag = new Solution().isPalindrome(" a");
        System.out.println(flag);
    }
}
