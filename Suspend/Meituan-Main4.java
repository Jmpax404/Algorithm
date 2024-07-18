import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main4 {
    private final static int M = (int) (Math.pow(10, 9)) + 7;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            in.nextLine();
            String str = in.nextLine();
            char[] cs = str.toCharArray();
            int m = 26;//字母总数
            int[] counts = new int[m];
            for (char c : cs) {
                counts[c - 'a']++;
            }
            int result = 0;
            int totalCount = n;
            while (totalCount > 0) {
                int countForCal = totalCount;
                int i = 0;
                int minusCount = 0;
                while (i < m && countForCal > 0) {
                    int t = counts[i];
                    countForCal -= t;
                    result = (result + ((t * countForCal) % M)) % M;
                    if (t > 0) {
                        counts[i]--;//消耗一个
                        minusCount++;
                    }
                    i++;
                }
                totalCount = totalCount - minusCount;
            }
            System.out.println(result % M);
        }
    }
}