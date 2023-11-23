public class Main {
    public int jump(int[] nums) {
        int max_far = 0;//目前能跳到的最远位置
        int step = 0;//跳跃次数
        int end = 0;//上次跳跃可达到范围的右边界
        for (int i = 0; i < nums.length-1; i++) {
            max_far = Math.max(max_far, i + nums[i]);//在到达右边界前找到下次最远的一跳
            if (i == end) {//到达上次跳跃能到达的右边界了
                end = max_far;
                step++;
            }
        }
        return step;
    }

    public int jump0(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int[] steps = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = nums[i], t; j > 0; j--) {
                min = (t = i + j) < n && steps[t] < min ? steps[t] : min;
            }
            steps[i] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
        }
        return steps[0];
    }

    public static void main(String[] args) {
        System.out.println(new Main().jump(new int[]{2, 3, 1, 1, 4}));
    }
}