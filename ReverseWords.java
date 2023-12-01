import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        reverse(cs, 0, n);
        int start = 0;
        int lastWordEnd = 0;
        for (int i = 0; i < n; i++) {
            if (cs[i] != ' ') {
                start = i;
                while (i < n && cs[i] != ' ') {
                    cs[lastWordEnd++] = cs[i++];
                }
                reverse(cs, lastWordEnd - (i - start), lastWordEnd);
                if (lastWordEnd < n) {
                    cs[lastWordEnd] = ' ';
                }
                lastWordEnd++;
            }

        }
        return String.valueOf(cs, 0, lastWordEnd - 1);
    }

    private void reverse(char[] cs, int start, int end) {
        int mid = start + ((end - start) >> 1);
        for (int i = start, j = end - 1; i < mid; i++, j--) {
            char t = cs[i];
            cs[i] = cs[j];
            cs[j] = t;
        }
    }

    public String reverseWords1(String s) {
        char[] cs = s.toCharArray();
        int end;
        StringBuilder sb = new StringBuilder();
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] != ' ') {
                end = i;
                while (i >= 0 && cs[i] != ' ') {
                    i--;
                }
                sb.append(s, i + 1, end + 1).append(' ');
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    public String reverseWords0(String s) {
        List<String> list = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("j    i love    you m"));
    }
}