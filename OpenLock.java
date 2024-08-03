import java.util.*;

public class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        for (String deadend : deadends) {
            visited.add(deadend);
        }
        Set<String> set1 = new HashSet<>();
        set1.add("0000");
        Set<String> set2 = new HashSet<>();
        set2.add(target);
        int step = 0;
        while (!set1.isEmpty() && !set2.isEmpty()) {//有一个为空说明全遍历完了

            Set<String> temp = new HashSet<>();//遍历同时不能修改
            for (String cur : set1) {
                if (visited.contains(cur)) {
                    continue;
                }
                visited.add(cur);

                if (set2.contains(cur)) {//逆向set中有顺向的元素
                    return step;
                }

                char[] cs = cur.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char c = cs[j];
                    cs[j] = (char) ((c - '0' + 1) % 10 + '0');
                    temp.add(new String(cs));
                    cs[j] = (char) ((c - '0' + 9) % 10 + '0');
                    temp.add(new String(cs));
                    cs[j] = c;
                }
            }

            if (set1.size() > set2.size()) {
                //交换set1和2。让下次是小的
                set1 = set2;
                set2 = temp;
            } else {
                set1 = temp;//不交换
            }
            step++;
        }
        return -1;
    }

    private String up(String str, int index) {
        char[] cs = str.toCharArray();
        cs[index] = (char) ((cs[index] - '0' + 1) % 10 + '0');
        return new String(cs);
    }

    private String down(String str, int index) {
        char[] cs = str.toCharArray();
        cs[index] = (char) ((cs[index] - '0' + 9) % 10 + '0');
        return new String(cs);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }
}
