import java.util.*;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(set::add);
        return set.stream().map((num) -> {
            if (!set.contains(num - 1)) {
                int curNum = num;
                while (set.contains(curNum + 1)) {
                    curNum++;
                }
                return curNum - num + 1;
            } else {
                return 0;
            }
        }).max(Comparator.comparingInt(o -> o)).get();
    }
}
