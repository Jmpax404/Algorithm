import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        traverse(nums, 0, new LinkedList<>());
        return res;
    }

    private void traverse(int[] nums, int index, LinkedList<Integer> track) {
        res.add(new ArrayList<>(track));
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {

            track.add(nums[i]);
            traverse(nums, i + 1, track);
            track.removeLast();

        }
    }

}


class Subsets2 {
    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        traverse(nums, 0, new LinkedList<>());
        return res;
    }

    private void traverse(int[] nums, int index, LinkedList<Integer> track) {
        if (index == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        // not select
        traverse(nums, index + 1, track);
        // select
        track.addLast(nums[index]);
        traverse(nums, index + 1, track);
        track.removeLast();
    }

}
