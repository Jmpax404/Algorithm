public class Solution {
    public boolean isValid(String s) {
        char[] cs = s.toCharArray();
        if (cs.length % 2 != 0) {
            return false;
        }
        char[] stack = new char[10000];
        int si = 0;
        for (char c : cs) {
            switch (c) {
                case '(':
                case '[':
                case '{': {
                    stack[si++] = c;
                    break;//不写break则直接执行default中内容了
                }
                default: {
                    if (si == 0) {
                        return false;
                    }
                    char ct = stack[--si];
                    if (!((ct == '(' && c == ')') ||
                            (ct == '[' && c == ']') ||
                            (ct == '{' && c == '}')
                    )) {
                        return false;
                    }
                }
            }
        }
        return si == 0;
    }
}