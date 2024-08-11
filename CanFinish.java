import java.util.ArrayList;
import java.util.List;

public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        for (int i = 0, len = prerequisites.length; i < len; i++) {
            graph[prerequisites[i][1]][prerequisites[i][0]] = 1;
        }
        int[] visited = new int[numCourses];
        boolean[] resP = new boolean[]{true};
        for (int i = 0; i < numCourses; i++) {
            dfs(graph, numCourses, i, visited, resP);
            if (!resP[0]) {
                return false;
            }
        }
        return resP[0];
    }

    private void dfs(int[][] graph, int numCourses, int index, int[] visited, boolean[] resP) {
        if (visited[index] == 1) {
            resP[0] = false;
            return;
        } else if (visited[index] == -1) {
            return;
        }
        visited[index] = 1;
        for (int i = 0; i < numCourses; i++) {
            if (graph[index][i] == 0) {
                continue;
            }
            dfs(graph, numCourses, i, visited, resP);
            if (!resP[0]) {
                return;
            }
        }
        visited[index] = -1;
    }
}

class Solution0 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            boolean res = dfs(graph, i, visited);
            if (!res) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<Integer>[] graph, int index, int[] visited) {
        if (visited[index] == -1) {
            return true;
        }
        if (visited[index] == 1) {
            return false;
        }
        visited[index] = 1;
        List<Integer> values = graph[index];
        if (values == null) {
            visited[index] = -1;//坑：没有设置回记录
            return true;
        }
        for (int v : values) {
            boolean res = dfs(graph, v, visited);
            if (!res) {//每一步只要是有false就返回false
                return false;
            }
        }
        visited[index] = -1;
        return true;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            if (graph[v] == null) {//允许非空就会出现一堆问题
                graph[v] = new ArrayList<>();
            }
            graph[v].add(u);
        }
        return graph;
    }

    public static void main(String[] args) {
        System.out.println(new CanFinish().canFinish(2, new int[][]{{1, 0}, {0, 1}

        }));
    }
}
