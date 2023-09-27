import java.io.IOException;
import java.util.*;

public class Main {

    /*其中有两个用例运行超时*/
    public static void main(String[] args) throws IOException {
        char c;
        char[] cs = new char[1048576];
        int i = 0;
        HashMap<String, Integer> map = new HashMap<>();
        while ((c = (char) System.in.read()) != '\n') {
            cs[i] = c;
            if (!isAN(c)) {
                if (i != 0) {
                    String st = String.valueOf(cs, 0, i).toLowerCase();
                    map.put(st, map.getOrDefault(st, 0) + 1);
                }
                i = 0;
            } else {
                i++;
            }
        }
        if (i > 0 && isAN(cs[i - 1])) {
            String st = String.valueOf(cs, 0, i).toLowerCase();
            map.put(st, map.getOrDefault(st, 0) + 1);
        }
        String maxStr = "";
        int maxCount = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount || entry.getValue() == maxCount && entry.getKey().compareTo(maxStr) < 0) {
                maxStr = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        System.out.println(maxStr + " " + maxCount);
    }

    private static boolean isAN(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

}