import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public int[] sort(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new QuickSort().sort(new int[]{6, 8, 3, 1, 4, 7, 2, 5})));
    }
}

class A {
    private final static Random random = new Random(System.currentTimeMillis());

    public int[] sortArray(int[] nums) {
        int[] buckets = new int[100001];
        int offset = 50000;
        for (int num : nums) {
            buckets[num + offset]++;
        }
        for (int i = 0, j = 0, end = buckets.length; i < end; i++) {
            int val = i - offset;
            for (int k = 0, size = buckets[i]; k < size; k++) {
                nums[j++] = val;
            }
        }
        return nums;
    }

    public int[] sortArray0(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort0(int[] nums, int left, int right) {
        if (left < right) {
            int pivotIndex = partition1(nums, left, right);
            quickSort0(nums, left, pivotIndex - 1);
            quickSort0(nums, pivotIndex + 1, right);
        }
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        //[left+1,lt)
        //[lt,i)
        //(gt,right]
        int lt = left + 1;
        int gt = right;
        int i = left + 1;
        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, i, lt);
                lt++;
                i++;
            } else if (nums[i] == pivot) {
                i++;
            } else {// nums[i] > pivot
                swap(nums, i, gt);
                gt--;
            }
        }
        swap(nums, left, lt - 1);
        quickSort(nums, left, lt - 1);
        quickSort(nums, gt + 1, right);
    }

    private int partition1(int[] nums, int left, int right) {// 双路快排
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int le = left + 1;//[left+1,le)
        int ge = right;//(ge,right]
        while (true) {
            while (le <= ge && nums[le] < pivot) {
                le++;
            }
            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }
            if (le >= ge) {
                swap(nums, left, ge);
                return ge;
            }
            swap(nums, le, ge);
        }

    }

    private int partition0(int[] nums, int left, int right) {// 单路快排
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        // [left+1,j]
        // (j,i)
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= pivot) {
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

}