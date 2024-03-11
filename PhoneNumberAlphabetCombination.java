import java.util.ArrayList;
import java.util.List;

public class Solution {
    private char[] nums;
    private int n;
    private List<String> list;
    private static char[][] d2c = new char[][]{
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        nums = digits.toCharArray();
        n = nums.length;
        list = new ArrayList<>();
        if (n == 0) {
            return list;
        }
        dfs(new char[5], 0);
        return list;
    }

    private void dfs(char[] cache, int i) {
        if (i == n) {
            list.add(new String(cache, 0, n));
        } else {
            int num = nums[i] - '0';
            char[] cs = d2c[num];
            for (int j = 0; j < cs.length; j++) {
                cache[i] = cs[j];
                dfs(cache, i + 1);
            }
        }
    }
}
