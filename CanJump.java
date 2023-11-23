public class Main {

    public boolean canJump(int[] nums) {
        int dest = nums.length - 1;
        for (int i = dest - 1; i >= 0; i--) {
            if (nums[i] >= dest - i) {
                dest = i;
            }
        }
        return dest == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Main().canJump(new int[]{0}));
    }
}
