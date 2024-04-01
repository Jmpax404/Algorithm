import java.util.*;

public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        int n = nums.length;
        for (int end = Math.min(k, n - 1); i <= end; i++) {
            int t = nums[i];
            if (set.contains(t)) {
                return true;
            }
            set.add(t);
        }
        for (; i < n; i++) {
            set.remove(nums[i - k - 1]);
            int t = nums[i];
            if (set.contains(t)) {
                return true;
            }
            set.add(t);
        }
        return false;
    }

    public boolean containsNearbyDuplicate0(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();//存放数值和数字对应最大的下标
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            Integer index;
            if ((index = map.get(t)) != null && i - index <= k) {
                return true;
            }
            map.put(t, i);
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2);
    }
}
