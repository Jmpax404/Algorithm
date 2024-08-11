import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                queue.offer(i);
                int color = 1;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int j = 0; j < size; j++) {
                        int u = queue.poll();
                        visited[u] = color;
                        for (int v : graph[u]) {
                            if (visited[v] == -color) {
                                continue;
                            } else if (visited[v] == color) {
                                return false;
                            }
                            queue.offer(v);
                        }
                    }
                    color = -color;
                }
            }
        }
        return true;
    }
}

class Solution1 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && !dfs(graph, i, visited, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int u, int[] visited, int color) {
        if (visited[u] != 0) {
            return visited[u] == color;
        }
        visited[u] = color;
        int[] vs = graph[u];
        for (int v : vs) {
            if (!dfs(graph, v, visited, -color)) {
                return false;
            }
        }
        return true;
    }
}