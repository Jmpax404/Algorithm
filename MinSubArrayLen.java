import java.util.Arrays;

class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] sums = new int[n + 1];//sum[0]=0
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int index = Arrays.binarySearch(sums, sums[i] + target);
            index = index < 0 ? ~index : index;//取反
            if (index <= n) {
                min = Math.min(min, index - i);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen1(int target, int[] nums) {
        int sum = 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (j < n) {
            sum += nums[j++];//加1个减多个
            while (sum >= target) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen0(int target, int[] nums) {
        int n = nums.length;
        int[] sums = new int[n];
        for (int k = 0; k < n; k++) {
            for (int i = n - 1 - k; i >= 0; i--) {
                int t = sums[i + k] + nums[i];
                if (t >= target) {
                    return k + 1;
                }
                sums[i + k] = t;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        int a = Arrays.binarySearch(new int[]{1, 2, 3, 5}, 4);
        /*
        3=011   100  101
        011 100 011 101
        -3=101
        -4=100
        */
        int b = (-a) - 1;
        System.out.println(a);
        System.out.println(b);
        System.out.println(
        );
        System.out.println(3);
        System.out.println(3 + 1);
        System.out.println(-(3 + 1));
    }
}