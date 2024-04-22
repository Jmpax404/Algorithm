public class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int lastVal = nums[n - 1];
        while (low < high) {
            int mid = low + ((high - low) >>> 1);
            if (nums[mid] >= lastVal) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

    public int findMin0(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >>> 1);
            if (nums[mid] >= nums[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return Math.min(nums[low], nums[high]);
    }
}
