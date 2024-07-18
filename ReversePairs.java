import java.util.Arrays;

public class Solution {
    public int reversePairs(int[] record) {
        int n = record.length;
        /**
         * 离散化的目的是把离散的数映射到一个连续的空间
         * 相同元素无所谓，因为这里比较的是相对位置。在二分搜索的时候，相同的数据总搜到相同的位置，也就是映射后有部分位置是空的。
         */
        int[] temp = new int[n];//9, 7, 5, 4, 6
        System.arraycopy(record, 0, temp, 0, n);
        Arrays.sort(temp);//4,5,6,7,9. o(nlogn)
        for (int i = 0; i < n; i++) {
            //找到原数组元素映射到排序后数组的位置
            int mapVal = Arrays.binarySearch(temp, record[i]) + 1;//o(nlogn)
            record[i] = mapVal;//操作后相当于原数组被映射为了：5，4，2，1，3,这样我们的桶就是12345
        }
        TreeArray treeArray = new TreeArray(n);//树状数组
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            treeArray.update(record[i], 1);
            res += treeArray.sum(record[i] - 1);//求前面的数据
        }
        return res;
    }

    class TreeArray {
        int[] tree;
        int n;

        public TreeArray(int n) {
            this.n = n;
            this.tree = new int[n + 1];//第0位不使用
        }

        public void update(int pos, int delta) {//单点更新
            while (pos <= n) {
                tree[pos] += delta;
                pos += lowBit(pos);
            }
        }

        public int sum(int pos) {//区间求和 [1, pos]
            int res = 0;
            while (pos >= 1) {
                res += tree[pos];
                pos -= lowBit(pos);
            }
            return res;
        }

        private int lowBit(int pos) {//lowBit
            return pos & (-pos);
        }
    }
}

class Solution10 {
    public int reversePairs(int[] record) {
        return mergeSort(record, 0, record.length - 1);
    }

    private int mergeSort(int[] record, int start, int end) {//两侧闭区间 [ , ]
        if (start >= end) {//递归退出条件
            return 0;
        }
        int count = 0;
        //分治
        int mid = (start + end) / 2;
        count += mergeSort(record, start, mid);
        count += mergeSort(record, mid + 1, end);
        //合并
        count += merge(record, start, end, mid);
        return count;
    }

    private int merge(int[] record, int start, int end, int mid) {
        int count = 0;
        //双指针
        int i = start;
        int j = mid + 1;
        int[] temp = new int[end - start + 1];//临时数组存放结果
        int k = 0;
        while (i <= mid && j <= end) {
            if (record[i] <= record[j]) {
                temp[k++] = record[i++];
            } else {
                temp[k++] = record[j++];
                /*
                只有左侧比右侧大的时候，出现逆序。
                左侧一个大，左侧的后面都比他大。
                 */
                count += mid - i + 1;
            }
        }
        while (i <= mid) {//右边遍历完了，左侧还剩了，没有逆序
            temp[k++] = record[i++];
        }
        while (j <= end) {//左边遍历完了，右侧剩了，也没有逆序
            temp[k++] = record[j++];
        }
        //复制回原数组 Object src, int srcPos, Object dest, int destPos, int length
        System.arraycopy(temp, 0, record, start, k);
        return count;
    }
}
