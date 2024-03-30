import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        int[][] res = new int[n + 1][2];
        int rn = 0;
        int i = 0;
        int intervalStart = newInterval[0];
        int intervalEnd = newInterval[1];
        //二分查找：找到第一个 end >= newInterval start 的区间
        int begin = 0;
        int end = n - 1;
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (intervals[mid][1] < intervalStart) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        //如果一个没有会落到最后一个，因此需要判断是否符合要求
        if(intervals[begin][1] >= intervalStart){
            i = begin;
        }else {
            i=n;
        }
        for (int j = 0; j < i; j++) {//把不符合要求的全部添加进去
            res[rn++] = intervals[j];
        }
        //计算新区间的开始
        int newStart = 0;
        if (i < n) {
            newStart = Math.min(intervalStart, intervals[i][0]);
        } else {//也可能 newInterval 的 start 直接最大了
            res[rn++] = new int[]{intervalStart, intervalEnd};
            return Arrays.copyOf(res, rn);
        }
        //二分查找：找到第一个 newInterval end <= end 的区间，也就是没有囊括住的区间
        begin=i;
        end=n-1;
        while (begin<end){
            int mid=(begin + end) / 2;
            if(intervalEnd > intervals[mid][1]){
                begin=mid+1;
            }else {
                end=mid;
            }
        }
        if(intervalEnd<=intervals[begin][1]){//说明符合条件
            i=begin;
        }else {//出来的也是不符合条件，说明一个符合的也没有
            i=n;
        }
        //加入新的区间
        if (i < n) {
            if (intervals[i][0] > intervalEnd) {//还有不重叠的区间，在后面继续添加
                res[rn++] = new int[]{newStart, intervalEnd};
            } else if (intervals[i][1] >= intervalEnd) {//融合区间
                res[rn++] = new int[]{newStart, intervals[i][1]};
                i++;
            }
        } else {//newInterval 的 end 直接最大了
            res[rn++] = new int[]{newStart, intervalEnd};
        }
        //添加剩余的区间
        while (i < n) {
            res[rn++] = intervals[i++];
        }
        return Arrays.copyOf(res, rn);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().insert(new int[][]{
                {2, 6},
                {7, 9},


        }, new int[]{15,18}));
    }
}
