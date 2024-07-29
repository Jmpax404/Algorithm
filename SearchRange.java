import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {//0205
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

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int n = nums.length;
        int left = 0, right = n; //[0,n],最后一位是为了一个没有的时候返回
        while (left < right) {//l==r时退出循环
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {//某条件
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        //如果需要将不存在的设置为-1，则结尾特判
        if (left == n || nums[left] != target) {
            res[0] = -1;
        } else {
            res[0] = left;
        }

        //最后一个
        right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == 0) {
            res[1] = -1;
        } else {
            res[1] = nums[left - 1] == target ? left - 1 : -1;
        }

        return res;
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {//nums[mid] < target
                left = mid + 1;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}