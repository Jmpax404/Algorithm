public class BasicCalculator1 {
    public int calculate(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int i = 0;
        int res = 0;
        int sign = 1;
        int[] stack = new int[n];
        int sn = 0;
        stack[sn++] = 1;
        while (i < n) {
            char c = cs[i];
            switch (c) {
                case ' ':
                    break;
                case '+':
                    sign = stack[sn - 1];
                    break;
                case '-':
                    sign = -stack[sn - 1];
                    break;
                case '(':
                    stack[sn++] = sign;
                    break;
                case ')':
                    --sn;
                    break;
                default: {//核心是在数字出现后直接计算结果
                    int num = 0;
                    while (i < n && (c = cs[i]) >= '0' && c <= '9') {
                        num = num * 10 + (c - '0');
                        i++;
                    }
                    res += sign * num;
                    i--;
                    break;
                }
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculator1().calculate("- (3 + (4 - 5))"));
    }
}
