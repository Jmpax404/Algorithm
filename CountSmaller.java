import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        System.arraycopy(nums, 0, temp, 0, n);
        Arrays.sort(temp);
        for (int i = 0; i < n; i++) {
            nums[i] = Arrays.binarySearch(temp, nums[i]) + 1;
        }
        int[] tree = new int[n + 1];
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int t = nums[i];
            for (int j = t; j <= n; j += j & (-j)) {
                tree[j] += 1;
            }
            for (int j = t - 1; j >= 1; j -= j & (-j)) {
                res[i] += tree[j];
            }
        }
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            resList.add(res[i]);
        }
        return resList;
    }

}

class Solution4 {

    /**
     * 统计的时候需要知道数字最开始在哪个位置。
     * 所以可以双向映射，hash，慢。
     * 或者，捆绑排序，但是捆绑排序后查找就很麻烦了，或者同时维护两个排序。
     * 或者把下标作为排序的显示值，比较用 下标 对应的数值进行，√。
     */
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] indexes = new int[n];
        int[] res = new int[n];//初始全为0
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        mergeSort(nums, indexes, res, 0, n - 1);
        List<Integer> resList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            resList.add(res[i]);
        }
        return resList;
    }

    private void mergeSort(int[] nums, int[] indexes, int[] res, int start, int end) {// [ , ]
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(nums, indexes, res, start, mid);
            mergeSort(nums, indexes, res, mid + 1, end);

            //优化：如果 归 后已经有序，那不可能存在逆序对，无需合并。
            if (nums[indexes[mid]] <= nums[indexes[mid + 1]]) {
                return;
            }

            merge(nums, indexes, res, start, end, mid);
        }
    }

    private void merge(int[] nums, int[] indexes, int[] res, int start, int end, int mid) {
        int[] temp = new int[end - start + 1];
        int k = 0;
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            //将indexes归并，比如第0个元素，归并后变成了第1个元素，那么nums[0]还是第0个，nums[indexes[0]]=nums[1]才是第一个元素的值
            //i<j,说明i比前一个j大了，此时统计的是i相关的逆序
            if (nums[indexes[i]] <= nums[indexes[j]]) {//元素相同的时候，让i先走，如果j先走，就会出现相等的元素被误认为逆序
                res[indexes[i]] += j - (mid + 1);//先计算逆序，不然下一条语句把i++了。
                temp[k++] = indexes[i++];
            } else {
                temp[k++] = indexes[j++];
            }
        }
        while (i <= mid) {//因为以i优先，那么如果想进入这个循环，一定是剩下的i大于最后一个j，因为相等的时候先走的是i
            res[indexes[i]] += j - (mid + 1);//先计算逆序，不然下一条语句把i++了。
            temp[k++] = indexes[i++];
        }
        while (j <= end) {
            temp[k++] = indexes[j++];
        }
        System.arraycopy(temp, 0, indexes, start, k);
    }

}

class Solution3 {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];//临时存放结果，不用List是因为List没法直接从后往前设置值
        int[] arr = new int[n];
        int an = 0;
        /**
         * 反向遍历，确保arr中的元素都是当前元素右侧的
         */
        for (int i = n - 1; i >= 0; i--) {
            int t = nums[i];
            /**
             * 插入排序
             * 找到第一个大于等于当前元素的位置。
             * 等于也需要，是因为等于不符合题目要求，通过尽量往前放，左边的都是符合题意的值
             */
            int j = getJ(arr, an, t);
            for (int k = an; k > j; k--) {
                arr[k] = arr[k - 1];
            }
            arr[j] = t;
            an++;
            res[i] = j;//要插入的位置左侧都是右侧比nums[i]小的元素
        }

        //设置结果
        List<Integer> resList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            resList.add(res[i]);
        }
        return resList;
    }

    private int getJ(int[] arr, int an, int t) {
        if (an == 0) {
            return 0;
        }
        int low = 0;
        int high = an - 1;
        //找到第一个比 t 大于等于的元素
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (t > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (arr[low] >= t) {
            return low;
        } else {
            return an;
        }
    }

}
