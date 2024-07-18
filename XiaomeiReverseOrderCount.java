import java.io.*;
import java.util.Arrays;

public class XiaomeiReverseOrderCount {

    public void method2(){
        //TODO 归并排序应该能同时求出右逆和左逆
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            //读取数据
            int n = (int) st.nval;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                st.nextToken();
                arr[i] = (int) st.nval;
            }

            //离散化
            int[] temp = new int[n];
            System.arraycopy(arr, 0, temp, 0, n);
            Arrays.sort(temp);
            for (int i = 0; i < n; i++) {
                arr[i] = Arrays.binarySearch(temp, arr[i]) + 1;//[1,n]
            }

            //求rightSmaller
            int[] rightSmaller = new int[n];
            int totalrightSmaller = 0;//总逆序对数
            int[] tree = new int[n + 1];
            for (int i = n - 1; i >= 0; i--) {
                int t = arr[i];
                for (int j = t; j <= n; j += j & (-j)) {
                    tree[j] += 1;
                }
                int count = 0;
                for (int j = t - 1; j >= 1; j -= j & (-j)) {
                    count += tree[j];
                }
                rightSmaller[i] = count;
                totalrightSmaller += count;
            }

            //求leftBigger
            int[] leftBigger = new int[n];
            tree = new int[n + 1];
            for (int i = 0; i < n; i++) {//遍历顺序是反的
                int t = arr[i];
                for (int j = t; j <= n; j += j & (-j)) {
                    tree[j] += 1;
                }
                int count = 0;//这里计算的是左面比t小的
                for (int j = t - 1; j >= 1; j -= j & (-j)) {
                    count += tree[j];
                }
                if (i != 0) {
                    leftBigger[i] = i - count;//去除小的那就是大的,不用考虑等于
                }
            }

            //输出结果
            int res = totalrightSmaller - rightSmaller[0] - leftBigger[0];
            pw.print(res);
            for (int i = 1; i < n; i++) {
                res = totalrightSmaller - rightSmaller[i] + i - leftBigger[i];
                pw.printf(" %d", res);
            }
            pw.println();
            pw.flush();
        }

        pw.close();
    }

}
