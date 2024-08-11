import java.util.*;

public class Solution {
    public int findJudge(int n, int[][] trust) {
        //build map
        int[][] map = new int[n + 1][n + 1];
        for (int i = 0, end = trust.length; i < end; i++) {
            map[trust[i][0]][trust[i][1]] = 1;
        }

        //add all to queue
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        if (n == 1) {
            return 1;
        }

        while (queue.size() >= 2) {
            int person1 = queue.poll();
            int person2 = queue.poll();
//            if (map[person1][person2] == 1) {
//                if (map[person2][person1] == 1) {
//                    // 他俩互相认识，肯定都不是名人
//                } else {
//                    //1认识2，但2不认识1，1一定不是
//                    queue.push(person2);
//                }
//            } else {
//                if (map[person2][person1] == 1) {
//                    queue.push(person1);
//                } else {
//                    //他俩互不认识，肯定都不是名人
//                }
//            }
            //位运算优化判断
            int a = map[person1][person2] == 1 ? 1 : 0;
            int b = map[person2][person1] == 1 ? 2 : 0;
            int c = a | b;
            if (c == 1) {
                queue.push(person2);
            } else if (c == 2) {
                queue.push(person1);
            }
        }

        if (queue.isEmpty()) {//最后两个节点也被删了
            return -1;
        }
        //要再次验证
        Integer person = queue.poll();
        for (int i = 1; i <= n; i++) {
            if (i == person) {
                continue;
            }
            if (map[person][i] == 1 || map[i][person] == 0) {
                return -1;
            }
        }
        return person;


    }
}