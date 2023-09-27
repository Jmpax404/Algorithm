import java.util.*;

public class Main {

    public static int[] cal(String s, int n, int[] kp) {
        int[] arr = new int[n];
        if (s.equals("0")) {
            kp[0] = 0;
            return arr;
        }
        int t = 0;
        if (s.charAt(0) == '0') {
            int zc = 0;
            for (int i = 2; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zc++;
                } else {
                    break;
                }
            }
            kp[0] = -zc;
            for (int i = zc + 2; i < s.length(); i++) {
                if (s.charAt(i) == '.') {
                    continue;
                }
                arr[t] = s.charAt(i) - 48;
                t++;
                if (t >= n) {
                    break;
                }
            }
        } else {
            int k = s.indexOf(".");
            if (k == -1) {
                k = s.length();
            }
            kp[0] = k;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '.') {
                    continue;
                }
                arr[t] = s.charAt(i) - 48;
                t++;
                if (t >= n) {
                    break;
                }
            }
        }
        return arr;
    }

    public static String removeRedundantZero(String s) {
        int p = s.indexOf('.');
        if (p == -1) {
            p = s.length();
        }
        StringBuilder sb = new StringBuilder();
        int i;
        boolean isLess1 = true;
        for (i = 0; i < p; i++) {
            if (s.charAt(i) != '0') {
                isLess1 = false;
                break;
            }
        }
        if (isLess1) {
            sb.append(0);
        } else {
            for (; i < p; i++) {
                sb.append(s.charAt(i));
            }
        }
        int j;
        boolean existDecimal = false;
        for (j = s.length() - 1; j > p; j--) {
            if (s.charAt(j) != '0') {
                existDecimal = true;
                break;
            }
        }
        if (existDecimal) {
            sb.append('.');
            for (int k = p + 1; k <= j; k++) {
                sb.append(s.charAt(k));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int[] kp1 = new int[1];
        int[] kp2 = new int[1];
        int[] arr1 = cal(removeRedundantZero(strings[1]), n, kp1);
        int[] arr2 = cal(removeRedundantZero(strings[2]), n, kp2);
        int k1 = kp1[0];
        int k2 = kp2[0];
        boolean isEqual = k1 == k2;
        if (isEqual && k1 != 0) {
            for (int i = 0; i < n; i++) {
                if (arr1[i] != arr2[i]) {
                    isEqual = false;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (isEqual) {
            sb.append("YES");
        } else {
            sb.append("NO");
        }
        sb.append(" 0.");
        Arrays.stream(arr1).forEach(sb::append);
        sb.append("*10^").append(k1);
        if (!isEqual) {
            sb.append(" 0.");
            Arrays.stream(arr2).forEach(sb::append);
            sb.append("*10^").append(k2);
        }
        System.out.print(sb);
    }
}