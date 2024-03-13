public class Solution {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }
        int left = 1;
        int right = nums.length - 2;
        int i = n / 2;
        while (i >= left && i <= right) {
            if (nums[i] > nums[i - 1]) {
                if (nums[i] > nums[i + 1]) {
                    return i;
                } else {
                    left=i+1;
                    if(left<=right){
                        i=(left+right)/2;
                    }else {
                        i=left;//相当于break
                    }
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    if (nums[i + 1] >= nums[i - 1]) {
                        i++;
                    } else {
                        i--;
                    }
                } else {
                    right=i-1;
                    if(right>=left){
                        i=(left+right)/2;
                    }else {
                        i=right;//相当于break
                    }
                }
            }
        }
        return i;
    }

    public static void main(String[] args) {
        new Solution().findPeakElement(new int[]{1,2,3});
    }

    public int findPeakElement0(int[] nums) {
        boolean isUp = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return i - 1;
            }
        }
        return nums.length - 1;
    }
}