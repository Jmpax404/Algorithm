import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public int hIndex(int[] citations) {
        int l = 0, r = citations.length;
        int m;
        while (l < r) {
            m = l + ((r - l + 1) >> 1);
            int count = 0;
            for (int citation : citations) {
                if (citation >= m) {
                    count++;
                }
            }
            if (count >= m) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    public int hIndex1(int[] citations) {
        int[] counts = new int[1001];
        for (int citation : citations) {
            counts[citation]++;
        }
        for (int len = counts.length, sum = 0, i = len - 1; i >= 1; i--) {
            if ((sum = counts[i] + sum) >= i) {
                return i;
            }
        }
        return 0;
    }

    public int hIndex0(int[] citations) {
        Arrays.sort(citations);
        for (int len = citations.length, i = len - 1; i >= 0; i--) {
            if (citations[i] <= len - i) {
                return citations[i];
            }
        }
        /*
            Arrays.sort(citations);
            int h = 0, i = citations.length - 1;
            while (i >= 0 && citations[i] > h) {
                h++;
                i--;
            }
        */
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Main().hIndex(new int[]{0}));
    }

}
