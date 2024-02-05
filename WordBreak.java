import java.util.List;

public class Solution {


    /**
     * BFS+记忆化
     * <p>
     * 这个题当出现a,aa,aaa,aaaa时，显然深度优先能更早发现不成立并进行记忆，广度需要很多层后才能access倒数几个元素
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        char[] cs = s.toCharArray();
        boolean[] visited = new boolean[cs.length + 1];
        visited[0] = true;
        int[] queue = new int[10000];
        int qs = -1, qe = -1;
        queue[++qs] = 0;
        while (qs != qe) {
            int index = queue[++qe];
            if (index == cs.length) {
                return true;
            }
            for (String word : wordDict) {
                int endIndex = index + word.length();
                if (endIndex <= cs.length && visited[endIndex]) {
                    continue;
                }
                if (s.startsWith(word, index)) {
                    visited[endIndex] = true;
                    queue[++qs] = endIndex;
                }
            }
        }
        return false;
    }


    /**
     * DFS+记忆化
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak0(String s, List<String> wordDict) {
        int[] cache = new int[s.length()];//记忆化
        return dfs(s, wordDict, 0, cache);
    }

    private boolean dfs(String s, List<String> wordDict, int start, int[] cache) {
        if (start == s.length()) {
            return true;
        }
        if (cache[start] > 0) {
            return cache[start] == 1;
        }
        for (String word : wordDict) {
            if (s.startsWith(word, start) && dfs(s, wordDict, start + word.length(), cache)) {
                cache[start] = 1;
                return true;
            }
        }
        cache[start] = 2;
        return false;
    }

}