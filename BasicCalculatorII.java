public class Solution {
    public int calculate(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int i = 0;
        int num = 0;
        char preOp = '+';
        int[] stack = new int[n];
        int sn = 0;
        while (i < n + 1) {
            char c = i == n ? '+' : cs[i];
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == ' ') {

            } else {
                switch (preOp) {
                    case '+':
                        stack[sn++] = num;
                        break;
                    case '-':
                        stack[sn++] = -num;
                        break;
                    case '*':
                        stack[sn - 1] = stack[sn - 1] * num;
                        break;
                    case '/':
                        stack[sn - 1] = stack[sn - 1] / num;
                        break;
                }
                preOp = c;
                num = 0;
            }
            i++;
        }
        int res = 0;
        while (sn > 0) {
            res += stack[--sn];
        }
        return res;
    }
}