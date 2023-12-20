import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        if (n == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        while (i < n) {
            int left = intervals[i][0];
            int compare = intervals[i][1];
            i++;
            while (i < n && compare >= intervals[i][0]) {
                compare = Math.max(compare, intervals[i][1]);
                i++;
            }
            res.add(new int[]{left, compare});
        }
        return res.toArray(new int[0][0]);
    }
}
