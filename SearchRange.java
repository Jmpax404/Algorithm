import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int mid;
        int[] ans = new int[2];
        if (left == right) {
            ans[0] = ans[1] = -1;
            return ans;
        }
        //find the first
        while (left < right) {
            mid = left + (right - left >>> 1);
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left < nums.length && nums[left] == target) {
            ans[0] = left;
        } else {
            ans[0] = ans[1] = -1;
            return ans;
        }
        //find the last, may be  equals with the first
        right = nums.length;
        while (left < right) {
            mid = left + (right - left >>> 1);
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        ans[1] = left - 1;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}