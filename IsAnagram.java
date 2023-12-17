import java.util.*;
import java.util.stream.Stream;

public class Solution {

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] hash = new int[26];
        for (char c : cs) {
            hash[c - 'a']++;
        }
        for (char c : ct) {
            int temp = --hash[c - 'a'];
            if (temp < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram0(String s, String t) {
        int n;
        if ((n = s.length()) != t.length()) {
            return false;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        for (int i = 0; i < n; i++) {
            if (cs[i] != ct[i]) {
                return false;
            }
        }
        return true;// return Arrays.equals(str1, str2);
    }

    public boolean isAnagram1(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        if (cs.length != ct.length) {
            return false;
        }
        for (char c : cs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ct) {
            Integer count = map.get(c);
            if (count == null) {
                return false;
            } else {
                count--;
                if (count < 0) {
                    return false;
                }
            }
            map.put(c, count);
        }
        return true;
    }

}
