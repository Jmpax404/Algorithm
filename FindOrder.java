import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites, inDegrees);
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        int[] res = new int[numCourses];
        int rn = 0;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            res[rn++] = cur;
            for (Integer to : graph[cur]) {
                inDegrees[to]--;
                if (inDegrees[to] == 0) {
                    queue.offer(to);
                }
            }
        }
        if (rn == numCourses) {
            return res;
        } else {
            return new int[0];
        }
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites, int[] inDegrees) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
            inDegrees[to]++;
        }
        return graph;
    }
}
