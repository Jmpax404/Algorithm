import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int x : nums) {
            b = b ^ x & ~(a = a ^ x & ~b);
        }
        return a;
    }

    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach((val) -> map.put(val, map.getOrDefault(val, 0) + 1));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public int singleNumber0(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        if (nums[0] != nums[1]) {
            return nums[0];
        } else if (nums[n - 2] != nums[n - 1]) {
            return nums[n - 1];
        }
        for (int i = 1, end = n - 1; i < end; i++) {
            if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }
}
