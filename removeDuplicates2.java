public class Solution {
    public int removeDuplicates0(int[] nums) {
        int j = 1, pre = nums[0], cur, t = 0;
        for (int i = 1, len = nums.length; i < len; i++) {
            if ((cur = nums[i]) == pre) {
                t++;
                if (t == 1) {
                    nums[j++] = cur;
                }
            } else {
                pre = nums[j++] = cur;
                t = 0;
            }
        }
        return j;
    }

    public int removeDuplicates1(int[] nums) {
        int j = 2;
        for (int i = 2, len = nums.length; i < len; i++) {
            if (nums[i] != nums[j - 2]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
