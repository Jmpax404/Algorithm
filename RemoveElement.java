public class Main {
    public int removeElement0(int[] nums, int val) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] != val) {
                i++;
            } else {
                while (j > i && nums[j] == val) {
                    j--;
                }
                if (j > i) {
                    nums[i] = nums[j];
                    i++;
                    j--;
                } else {
                    return i;
                }
            }
        }
        return i;
    }

    public int removeElement1(int[] nums, int val) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] != val) {
                i++;
            } else {
                nums[i] = nums[j--];
            }
        }
        return i;
    }
}
