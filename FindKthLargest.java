import java.util.PriorityQueue;
import java.util.Random;

public class Solution {

    private final static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int index = n - k;
        int left = 0;
        int right = n - 1;
        while (true) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex < index) {
                left = pivotIndex + 1;
            } else if (pivotIndex == index) {
                return nums[pivotIndex];
            } else {
                right = pivotIndex - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = random.nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int le = left + 1; // [left+1,le)
        int ge = right; // (ge,right]
        while (true) {
            while (le <= ge && nums[le] < pivot) {
                le++;
            }
            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }
            if (le >= ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;
        }
        swap(nums, left, ge);
        return ge;
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }


    public int findKthLargest1(int[] nums, int k) {//小根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public int findKthLargest0(int[] nums, int k) {//大根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> e2 - e1);
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
        int count = 0;
        int t = 0;
        while (count < k) {
            t = pq.poll();
            count++;
        }
        return t;
    }

}
