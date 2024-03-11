public class LRUCache {
    Node[] map;
    DoubleCircularLinkedList list;

    public LRUCache(int capacity) {
        map = new Node[10001];
        list = new DoubleCircularLinkedList(capacity);
    }

    public int get(int key) {
        Node node = map[key];
        if (node == null) {
            return -1;
        }
        list.remove(node);
        list.addFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map[key];
        if (node == null) {
            node = new Node(key, value);
            map[key] = node;
            int removeKey = list.addFirst(node);
            if (removeKey != -1) {
                map[removeKey] = null;
            }
        } else {
            node.val = value;
            list.remove(node);
            list.addFirst(node);
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 0);
        lRUCache.put(2, 2);
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));  // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }
}

class Node {
    Node prev;
    Node next;
    int key;
    int val;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoubleCircularLinkedList {
    Node sentinel;
    int n;
    int capacity;

    public DoubleCircularLinkedList(int capacity) {
        sentinel = new Node(-1, -1);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        n = 0;
        this.capacity = capacity;
    }

    public int addFirst(Node node) {
        int key = -1;
        if (n >= capacity) {
            key = sentinel.prev.key;
            remove(sentinel.prev);
        }
        Node nextNode = sentinel.next;
        sentinel.next = node;
        node.prev = sentinel;
        node.next = nextNode;
        nextNode.prev = node;
        n++;
        return key;
    }

    public void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        n--;
    }
}
