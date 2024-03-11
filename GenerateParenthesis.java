import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> ans;

    public List<String> generateParenthesis(int n) {
        char[] str = new char[n * 2];
        ans = new ArrayList<>();
        dfs(str, n, 0, 0, 0);
        return ans;
    }

    private void dfs(char[] str, int n, int i, int left, int right) {
        if (left > n || right > left) {
            return;
        }
        if (i == n * 2) {
            ans.add(new String(str));
            return;
        }
        str[i] = '(';
        dfs(str, n, i + 1, left + 1, right);
        str[i] = ')';
        dfs(str, n, i + 1, left, right + 1);
        str[i] = '\0';
    }
}
