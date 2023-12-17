import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] cp = pattern.toCharArray();
        char[] cs = s.toCharArray();
        int[] hash = new int[26];//index+1
        int n = cs.length;
        int m = cp.length;
        int i = 0;
        int j = 0;
        HashMap<Integer, Integer> hashMap = new HashMap();
        while (i < m && j < n) {//j maybe n+1
            int curPatternIndex = cp[i] - 'a';
            int t;
            if ((t = hash[curPatternIndex]) == 0) {
                hash[curPatternIndex] = j + 1;
                int key = 0;
                while (j < n && cs[j] != ' ') {
                    key *= 26;
                    key += cs[j] - 'a';
                    j++;
                }
                if (hashMap.get(key) != null && hashMap.get(key) != curPatternIndex) {
                    return false;
                }
                hashMap.put(key, curPatternIndex);
            } else {
                t--;
                int key = 0;
                while (j < n && cs[t] != ' ') {//last can't participate
                    if (cs[t] != cs[j]) {
                        return false;
                    }
                    key *= 26;
                    key += cs[j] - 'a';
                    t++;
                    j++;
                }
                if (j < n) {
                    if (cs[j] != ' ') {
                        break;
                    }
                } else {
                    if (cs[t] != ' ') {
                        break;
                    }
                }
                if (hashMap.get(key) != curPatternIndex) {
                    break;//reverse match
                }
            }
            i++;
            j++;
        }
        return i == m && j >= n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("abc", "dog cat dog"));
    }
}