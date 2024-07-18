public class Main {
    public static void main(String[] args) {

    }
}

/**
 * 树状数组
 */
class NumArray {
    int[] nums;
    int[] tree;//从1开始
    int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    private void add(int pos, int delta) {
        while (pos <= n) {
            tree[pos] += delta;
            pos += lowBit(pos);
        }
    }

    private int lowBit(int pos) {
        return pos & (-pos);
    }

    public void update(int index, int val) {
        int delta = val - nums[index];
        nums[index] = val;
        add(index + 1, delta);
    }

    public int sumRange(int left, int right) {
        int ans = 0;
        right++;
        while (right > 0) {
            ans += tree[right];
            right -= lowBit(right);
        }
        while (left > 0) {
            ans -= tree[left];
            left -= lowBit(left);
        }
        return ans;
    }
}