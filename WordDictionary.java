import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Solution {


}


class WordDictionary {
    TreeNode root = new TreeNode();

    class TreeNode {
        TreeNode[] list = new TreeNode[26];
        boolean isWord;
    }

    public WordDictionary() {

    }

    public void addWord(String word) {
        char[] cs = word.toCharArray();
        TreeNode node = root;
        for (int i = 0, len = cs.length; i < len; i++) {
            int index = cs[i] - 'a';
            TreeNode cur = node.list[index];
            if (cur == null) {
                cur = new TreeNode();
                node.list[index] = cur;
            }
            node = cur;
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        char[] cs = word.toCharArray();
        return dfs(cs, 0, root);
    }

    private boolean dfs(char[] cs, int index, TreeNode node) {
        if (index == cs.length) {
            return node.isWord;
        }
        if (cs[index] == '.') {
            for (int k = 0; k < 26; k++) {
                if (node.list[k] != null && dfs(cs, index + 1, node.list[k])) {
                    return true;
                }
            }
            return false;
        } else {
            TreeNode cur = node.list[cs[index] - 'a'];
            if (cur == null) {
                return false;
            } else {
                return dfs(cs, index + 1, cur);
            }
        }
    }

    public boolean searchBFS(String word) {
        char[] cs = word.toCharArray();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        for (int i = 0, len = cs.length; i < len; i++) {
            int queueSize = queue.size();
            int index = cs[i] - 'a';
            for (int j = 0; j < queueSize; j++) {
                TreeNode cur = queue.poll();
                TreeNode[] curChildren = cur.list;
                if (index == '.' - 'a') {
                    for (int k = 0, curChildrenLen = curChildren.length; k < curChildrenLen; k++) {
                        if (curChildren[k] != null) {
                            queue.offer(curChildren[k]);
                        }
                    }
                } else {
                    if (curChildren[index] != null) {
                        queue.offer(curChildren[index]);
                    }
                }
            }
            if (queue.isEmpty()) {
                return false;
            }
        }
        while (!queue.isEmpty()) {
            if (queue.poll().isWord) {
                return true;
            }
        }
        return false;
    }

}


