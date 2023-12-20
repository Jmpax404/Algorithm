import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int start = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int end = i - 1;
            StringBuilder sb = new StringBuilder(String.valueOf(nums[start]));
            if (start < end) {
                sb.append("->").append(nums[end]);
            }
            list.add(sb.toString());
        }
        return list;
    }

    public List<String> summaryRanges0(int[] nums) {
        List<String> list = new ArrayList<>();
        int a = 0;
        int n = nums.length;
        if (n == 0) {
            return list;
        }
        int bv = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] != bv + 1) {
                if (a == i - 1) {
                    list.add(String.format("%d", nums[a]));
                } else {
                    list.add(String.format("%d->%d", nums[a], nums[i - 1]));
                }

                a = i;
            }
            bv = nums[i];
        }
        if (a == n - 1) {
            list.add(String.format("%d", nums[a]));
        } else {
            list.add(String.format("%d->%d", nums[a], nums[n - 1]));
        }
        return list;
    }
}