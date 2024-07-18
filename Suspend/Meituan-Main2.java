import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            long k = in.nextLong();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr, (o1, o2) -> {
                o1 = Math.abs(o1);
                o2 = Math.abs(o2);
                return o1 - o2;
            });
            int i = 0;
            while (i < n) {
                k -= Math.abs(arr[i]);
                if (k < 0) {

                    break;
                }
                i++;
            }
            System.out.println(i);
        }
    }
}