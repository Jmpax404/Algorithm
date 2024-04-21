public class Solution {
    /*
    将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
    此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
    */
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[low]) {// 一定在左半部分
                if (target < nums[mid] && target >= nums[low]) { // 一定在 mid 左侧
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {// nums[mid] < nums[low] 一定在右半部分
                if (target > nums[mid] && target <= nums[high]) { // 一定在 mid 右侧
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{5, 1, 3}, 0));
    }
}
