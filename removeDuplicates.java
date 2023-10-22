class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1, pre = nums[0];
        for (int i = 1, len = nums.length; i < len; i++) {
            if (nums[i] != pre) {
                pre = nums[j++] = nums[i];
            }
        }
        return j;
    }
}