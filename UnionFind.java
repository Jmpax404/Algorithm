public class UnionFind {
    int[] parents;

    public UnionFind(int size) {
        parents = new int[size];
        for (int i = 0; i < size; i++) {
            parents[i] = i;
        }
    }

    public int find(int node) {
        while (parents[node] != node) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }
        return node;
    }

    public void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 != root2) {
            parents[root2] = root1;
        }
    }

    boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }


}
