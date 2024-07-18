import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();

            if (3 * a + 4 * b > n) {
                System.out.println(-1);
                continue;
            }


            int left = n - 3 * a - 4 * b;
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < a; i++) {
                pw.print("mei");
            }
            for (int i = 0; i < b; i++) {
                pw.print("tuan");
            }
            for (int i = 0; i < left; i++) {
                pw.print('x');
            }
            pw.print('\n');
            pw.flush();
            pw.close();
        }
    }
}