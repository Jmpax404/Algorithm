import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        int bn = bank.length;
        int n = bn + 1;
        boolean[][] graph = new boolean[n][n];
        //construct graph
        for (int i = 0, end = bn - 1; i < end; i++) {
            for (int j = i + 1; j < bn; j++) {
                graph[j][i] = graph[i][j] = isConnected(bank[i], bank[j]);
            }
            graph[i][bn] = isConnected(bank[i], startGene);
        }
        for (int i = 0; i < bn; i++) {
            graph[bn][i] = graph[i][bn] = isConnected(startGene, bank[i]);
        }
        //bfs
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(bn);
        boolean[] visited = new boolean[n];
        int step = 0;
        while (!queue.isEmpty()) {
            int qn = queue.size();
            while (qn-- > 0) {
                Integer cur = queue.pop();
                if (cur < bn && bank[cur].equals(endGene)) {
                    return step;
                }
                for (int i = 0; i < n; i++) {
                    if (!visited[cur] && graph[cur][i]) {
                        queue.offer(i);
                    }
                }
                visited[cur] = true;
            }
            step++;
        }
        return -1;
    }

    private boolean isConnected(String s1, String s2) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (cs1[i] != cs2[i]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minMutation(
                "AACCGGTT",
                "AACCGGTA",
                new String[]{"AACCGGTA",
                }
        ));
    }
}