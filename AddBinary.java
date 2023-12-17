public class Main {

    public String addBinary(String a, String b) {
        char[] csLong, csShort;
        if (a.length() >= b.length()) {
            csLong = a.toCharArray();
            csShort = b.toCharArray();
        } else {
            csLong = b.toCharArray();
            csShort = a.toCharArray();
        }
        int nL = csLong.length;
        int nS = csShort.length;
        int carry = 0;
        int iL = nL - 1, iS = nS - 1;
        for (; iS >= 0; iL--, iS--) {
            int t = csLong[iL] - '0' + csShort[iS] - '0' + carry;
            csLong[iL] = (char) (t % 2 + '0');
            carry = t / 2;
        }
        for (; iL >= 0; iL--) {
            int t = csLong[iL] - '0' + carry;
            csLong[iL] = (char) (t % 2 + '0');
            carry = t / 2;
        }
        return (carry == 0 ? "" : '1') + new String(csLong);
    }
}
