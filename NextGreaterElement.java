import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] greater = calculateGreaterElement(nums2);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], greater[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    private int[] calculateGreaterElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {//单调栈保证底下的元素大于上面
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().calculateGreaterElement(new int[]{2, 1, 2, 4, 3});
    }
}
