import java.util.Arrays;
import java.util.OptionalInt;

public class Main {

    /*

 i表示i+1的左侧，j表示j-1的右侧
 leftMaxI>=rightMaxJ => leftMaxJ>=leftMaxI>=rightMaxJ => rightMaxJ
 当一侧处理完了，说明判断完了，就动那一侧往中心走

    */
    public int trap(int[] height) {
        int ans = 0;
        for (int n = height.length, i = 1, j = n - 2, leftI = 0, rightJ = 0; i <= j; ans += ((leftI = Math.max(leftI, height[i - 1])) >= (rightJ = Math.max(rightJ, height[j + 1]))) ? Math.max(rightJ - height[j--], 0) : Math.max(leftI - height[i++], 0));
        return ans;
    }

    public int trap2(int[] height) {//空间换时间,dp
        int n = height.length;
        int[] lefts = new int[n];
        int[] rights = new int[n];
        for (int i = 1; i < n; i++) {
            lefts[i] = Math.max(lefts[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rights[i] = Math.max(rights[i + 1], height[i + 1]);
        }
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(lefts[i], rights[i]);
            if (min > height[i]) {
                ans += min - height[i];
            }
        }
        return ans;
    }

    public int trap1(int[] height) {//对每一列判断是否能接水
        int count = 0;
        int n = height.length;
        for (int i = 1, nm1 = n - 1; i < nm1; i++) {
            int ch = height[i];
            int left = i - 1;
            int right = i + 1;
            int leftMax = 0, rightMax = 0;
            while (left >= 0) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                }
                left--;
            }
            while (right < n) {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                }
                right++;
            }
            int min = Math.min(leftMax, rightMax);
            if (min > ch) {
                int t = min - ch;
                count += t;
            }
        }
        return count;
    }

    public int trap0(int[] height) {//一层一层接水
        int n = height.length;
        int h = 1;
        int s = 0;
        int total = 0;
        OptionalInt maxOptional = Arrays.stream(height).max();
        int max = maxOptional.getAsInt();
        while (h <= max) {
            //find the first left boarder
            int i = 0;
            s = 0;
            while (height[i] < h) {
                i++;
            }
            for (++i; i < n; i++) {
                if (height[i] >= h) {
                    total += s;
                    s = 0;
                } else {
                    s++;
                }
            }
            h++;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new Main().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
