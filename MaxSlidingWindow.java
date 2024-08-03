import java.util.*;

public class AAA {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res[i - k + 1] = window.max();
                window.pop(nums[i - k + 1]);
            }
        }
        return res;
    }
}


class MonotonicQueue {
    private Deque<Integer> queue = new LinkedList<>();

    //你可以想象，加入数字的大小代表人的体重，体重大的会把前面体重不足的压扁，直到遇到更大的量级才停住。
    public void push(int x) {
        while (!queue.isEmpty() && queue.peekLast() < x) {
            queue.pollLast();
        }
        queue.offerLast(x);//无论如何都得插入，因此上面没把相等的删了
    }

    public void pop(int x) {
        if (queue.peekFirst() == x) {
            queue.removeFirst();
        }
    }

    public int max() {
        return queue.peekFirst();
    }
}