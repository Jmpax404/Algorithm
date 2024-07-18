import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main3 {
    private final static int M = (int) (Math.pow(10, 9)) + 7;
    //private final static int M = 3;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int q = in.nextInt();
            in.nextLine();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int[] masks = new int[n + 1];
            int[] cache = new int[q + 1];//存放2^x % M
            cache[0] = 1;
            for (int i = 1; i <= q; i++) {
                masks[in.nextInt()]++;
                in.nextLine();
                cache[i] = (cache[i - 1] * 2) % M;

            }
            //
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                //(q-masks[i])实际的倍数
                //ans = (ans + ((cache[q - masks[i]] * arr[i - 1]) % M)) % M;

                int doubleCount = q - masks[i];
                int addon = cache[doubleCount] * arr[i - 1];

                ans += addon % M;
            }
            System.out.println(ans % M);
        }
    }
}