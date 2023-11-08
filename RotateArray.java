import java.util.Arrays;

public class Main {
    static class Solution {

        public void rotate(int[] nums, int k) {// o(2n), o(1)
            int n = nums.length;
            k %= n;
            reverse(nums, n - k, n);
            reverse(nums, 0, n - k);
            reverse(nums, 0, n);
        }

        private void reverse(int[] nums, int s, int e) {// [s,e)
            for (int i = s, j = e - 1, end = (e + s) / 2; i < end; i++, j--) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }

        public void rotate2(int[] nums, int k) {// o(n), o(1)
            int n = nums.length;
            int count = 0;
            int i = 0;
            while (count < n) {
                int startIndex = i;
                int r = nums[i];
                do {
                    int ik = (i + k) % n;
                    int f = nums[ik];
                    nums[ik] = r;
                    r = f;
                    i = (i + k) % n;
                    count++;
                } while (i != startIndex);
                i++;
            }
        }

        public void rotate1(int[] nums, int k) {// o(n+2k), o(k)
            k %= nums.length;
            int[] ts = new int[k];
            for (int len = nums.length, i = len - k, j = 0; i < len; i++) {
                ts[j++] = nums[i];
            }
            for (int i = nums.length - k - 1; i >= 0; i--) {
                nums[i + k] = nums[i];
            }
            for (int i = 0; i < k; i++) {
                nums[i] = ts[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new Solution().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}