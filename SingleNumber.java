public class Solution {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1, len = nums.length; i < len; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
