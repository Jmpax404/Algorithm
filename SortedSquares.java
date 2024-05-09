package com.jmpax.auto;

import java.util.Arrays;

public class Solution {

    /* 优化：从大往小双指针 */

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0;
        int right = firstGE0(nums, n);
        int left = right - 1;

        while (left >= 0 && right < n) {
            if (-nums[left] >= nums[right]) {
                int t = nums[right++];
                res[i++] = t * t;
            } else if (-nums[left] < nums[right]) {
                int t = nums[left--];
                res[i++] = t * t;
            }
        }

        while (right < n) {
            int t = nums[right++];
            res[i++] = t * t;
        }

        while (left >= 0) {
            int t = nums[left--];
            res[i++] = t * t;
        }

        return res;
    }

    private int firstGE0(int[] nums, int n) {
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= 0) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (nums[high] < 0) {
            return n;
        } else {
            return high;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}
