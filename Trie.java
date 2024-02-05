public class Trie {
    private TreeNode head;

    class TreeNode {
        TreeNode[] children;
        boolean isWord;

        public TreeNode() {
            children = new TreeNode[26];
        }
    }

    public Trie() {
        head = new TreeNode();
    }

    public void insert(String word) {
        char[] words = word.toCharArray();
        TreeNode t = head;
        for (char c : words) {
            TreeNode tc = t.children[c - 'a'];
            if (tc == null) {
                tc = t.children[c - 'a'] = new TreeNode();
            }
            t = tc;
        }
        t.isWord = true;
    }

    public boolean search(String word) {
        TreeNode t = startWithTreeNode(word);
        return t != null && t.isWord;
    }

    public boolean startsWith(String prefix) {
        return startWithTreeNode(prefix) != null;
    }

    private TreeNode startWithTreeNode(String prefix) {
        char[] words = prefix.toCharArray();
        TreeNode t = head;
        for (char c : words) {
            TreeNode tc;
            if (t == null || (tc = t.children[c - 'a']) == null) {
                return null;
            }
            t = tc;
        }
        return t;
    }
}