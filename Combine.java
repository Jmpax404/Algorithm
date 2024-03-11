import java.util.*;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(n, k, 1, new LinkedList<>(), ans);
        return ans;
    }

    private void dfs(int n, int k, int pos, LinkedList<Integer> stack, List<List<Integer>> ans) {
        if (stack.size() == k) {
            ans.add(new ArrayList<>(stack));
        } else {
            for (int i = pos, end = n - (k - stack.size()) + 1; i <= end; i++) {// 回溯+剪枝
                stack.addLast(i);
                dfs(n, k, i + 1, stack, ans);
                stack.removeLast();
            }
        }
    }
}
