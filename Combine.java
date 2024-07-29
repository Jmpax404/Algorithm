import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(n, k, 1, new LinkedList<>(), res);
        return res;
    }

    private void traverse(int n, int k, int start, LinkedList<Integer> track, List<List<Integer>> res) {
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            traverse(n, k, i + 1, track, res);
            track.removeLast();
        }
    }

}