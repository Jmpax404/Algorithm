import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsWithDup {//可以不用visited
    private List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new LinkedList<>();
        Arrays.sort(nums);
        traverse(nums, 0, new LinkedList<>());
        return res;
    }

    private void traverse(int[] nums, int start, LinkedList<Integer> track) {
        res.add(new ArrayList<>(track));
        int n = nums.length;
        //进不去for循环也就结束了
//        if (start > n) {
//            return;
//        }
        for (int i = start; i < n; i++) {
            if (i > start && nums[i] == nums[i - 1]) {//>start 限制了起始位置
                continue;
            }
            track.add(nums[i]);
            traverse(nums, i + 1, track);
            track.removeLast();
        }
    }

}

class Solution0 {
    private List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        traverse(nums, 0, new LinkedList<>(), visited);
        return res;
    }

    private void traverse(int[] nums, int start, LinkedList<Integer> track, boolean[] visited) {
        res.add(new ArrayList<>(track));
        int n = nums.length;
        if (start > n) {
            return;
        }
        for (int i = start; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            track.add(nums[i]);
            traverse(nums, i + 1, track, visited);
            track.removeLast();
            visited[i] = false;
        }
    }
}
