import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permute {
    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        int n = nums.length;
        boolean[] visited = new boolean[n];
        LinkedList<Integer> route = new LinkedList<>();
        traverse(nums, 0, route, visited);
        return res;
    }

    private void traverse(int[] nums, int index, LinkedList<Integer> route, boolean[] visited) {
        int n = nums.length;
        if (index == n) {
            res.add(new ArrayList<>(route));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            route.add(nums[i]);

            traverse(nums, index + 1, route, visited);

            route.removeLast();
            visited[i] = false;
        }


    }
}


class Permute2 {
    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        traverse(nums, 0);
        return res;
    }

    private void traverse(int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            traverse(nums, start + 1);
            swap(nums, start, i);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}



