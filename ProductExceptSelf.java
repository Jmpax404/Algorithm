import java.util.Arrays;

public class Main {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, beforeSum = 1; i < n; i++) {
            ans[i] = beforeSum;
            beforeSum *= nums[i];
        }
        for (int j = n - 1, afterSum = 1; j >= 0; j--) {
            ans[j] *= afterSum;
            afterSum *= nums[j];
        }
        return ans;
    }

    public int[] productExceptSelf0(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new Main().productExceptSelf(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(a));
    }
}
