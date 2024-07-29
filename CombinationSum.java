import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(candidates, target, 0, new LinkedList<>(), 0, res);
        return res;
    }

    private void traverse(int[] candidates, int target, int start, LinkedList<Integer> track, int sum, List<List<Integer>> res) {

        if (sum == target) {
            res.add(new ArrayList<>(track));
            return;
        } else if (sum > target) return;

        int n = candidates.length;
        for (int i = start; i < n; i++) {
            track.add(candidates[i]);
            sum += candidates[i];
            traverse(candidates, target, i, track, sum, res);
            sum -= candidates[i];
            track.removeLast();
        }

    }
}