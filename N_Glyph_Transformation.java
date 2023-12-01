class Solution {
    public String convert(String s, int r) {
        if (r == 1) {
            return s;
        }
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, n = cs.length, rm1 = r - 1; i < r; i++) {
            int k = i;
            int step = i;
            while (k < n) {
                sb.append(cs[k]);
                step = rm1 - step;
                step = step == 0 ? rm1 : step;
                k += step << 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convert("A", 1));
    }
}