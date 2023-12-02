import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0, n = words.length;
        List<String> list = new ArrayList<>();
        while (i < n) {
            int start = i, widthLeast = -1, width = 0, cur;
            while (i < n && widthLeast + (cur = words[i].length()) + 1 <= maxWidth) {
                widthLeast += cur + 1;
                width += cur;
                i++;
            }
            StringBuilder sb = new StringBuilder();
            if (i == n) {
                sb.append(words[start]);
                for (int j = start + 1; j < i; j++) {
                    sb.append(' ').append(words[j]);
                }
                for (int j = 0, len = maxWidth - widthLeast; j < len; j++) {
                    sb.append(' ');
                }
            } else {
                int space = maxWidth - width, spacePer, left, t;
                spacePer = space / ((t = i - start - 1) == 0 ? 1 : t);
                left = space - spacePer * t;
                sb.append(words[start]);
                for (int j = start + 1; j < i; j++) {
                    if(left>0){
                        sb.append(' ');
                        left--;
                    }
                    for (int k = 0; k < spacePer; k++) {
                        sb.append(' ');
                    }
                    sb.append(words[j]);
                }
                for (int k = 0; k < left; k++) {
                    sb.append(' ');
                }
            }
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = new Solution().fullJustify(
                new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"},
                20
        );
        for (String s : list) {
            System.out.println(">" + s + "<");
        }
    }
}
