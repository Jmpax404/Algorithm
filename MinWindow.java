import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        int sn = ss.length;
        int tn = ts.length;

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> cur = new HashMap<>();

        for (int i = 0; i < tn; i++) {
            map.put(ts[i], map.getOrDefault(ts[i], 0) + 1);
        }
        int totalChar = map.size();

        int i = 0, j = 0;
        int finishedChar = 0;
        int resStart = 0;
        int resEnd = 0;
        int minLength = Integer.MAX_VALUE;

        while (i < sn) {
            int cCount = map.getOrDefault(ss[i], 0);


            if (cCount > 0) {
                int curICount = cur.getOrDefault(ss[i], 0);
                cur.put(ss[i], ++curICount);//匹配到的字符只能多不能少
                if (curICount == cCount) {//只有恰好匹配上才算一个字符完成
                    finishedChar++;
                }
            }

            i++;

            while (finishedChar == totalChar) {

                if (i - j < minLength) {
                    minLength = i - j;
                    resStart =j;
                    resEnd = i;
                }

                int cCountJ = cur.getOrDefault(ss[j], 0);
                if (cCountJ > 0) {
                    if (map.get(ss[j]).equals(cCountJ)) {
                        finishedChar--;
                    }
                    cur.put(ss[j], cCountJ - 1);
                }
                j++;
            }
        }

        return s.substring(resStart, resEnd);
    }

    public static void main(String[] args) {
        new Solution().minWindow("ADOBECODEBANC", "ABC");
    }
}
