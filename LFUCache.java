public class LFUCache {
    int capacity;
    DoubleNode[] map;
    DoubleLinkedList[] levelLists;
    int count;
    int firstNotEmptyListIndex;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new DoubleNode[100001];
        levelLists = new DoubleLinkedList[200001];
        this.count = 0;
    }

    public int get(int key) {
        DoubleNode node = map[key];
        if (node == null) {
            return -1;
        }
        goNextLevel(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleNode node = map[key];
        if (node == null) {
            if (count >= capacity) {
                removeLeftestOldestNode();
                count--;
            }
            node = new DoubleNode(key, value);
            goNextLevel(node);
            map[key] = node;
            count++;
            firstNotEmptyListIndex = 1;//跟满了抽不抽书没关系，只要有新的就是1
        } else {
            node.value = value;
            goNextLevel(node);
        }
    }

    private void goNextLevel(DoubleNode node) {
        int curLevel = node.cnt;
        if (curLevel != 0) {
            DoubleLinkedList curList = levelLists[curLevel];
            curList.removeNode(node);
            if (curList.isEmpty()) {
                levelLists[curLevel] = null;
                if (firstNotEmptyListIndex == curLevel) {//抽出来的书是最左侧的最后一个
                    firstNotEmptyListIndex++;
                }
            }
        }
        int nextLevel = ++node.cnt;
        DoubleLinkedList nextList = levelLists[nextLevel];
        if (nextList == null) {
            nextList = levelLists[nextLevel] = new DoubleLinkedList();
        }
        nextList.addLast(node);
    }

    private void removeLeftestOldestNode() {
        DoubleLinkedList curList = levelLists[firstNotEmptyListIndex];
        int removedKey = curList.removeFirst();
        map[removedKey] = null;
        if (curList.isEmpty()) {
            levelLists[firstNotEmptyListIndex] = null;
        }
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));

    }

}

class DoubleLinkedList {
    DoubleNode head;
    DoubleNode tail;

    public DoubleLinkedList() {
        head = new DoubleNode(0, 0);
        tail = new DoubleNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void insertNode(DoubleNode prevNode, DoubleNode newNode) {
        DoubleNode nextNode = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = nextNode;
        nextNode.prev = newNode;
    }

    public void removeNode(DoubleNode curNode) {
        DoubleNode preNode = curNode.prev;
        DoubleNode nextNode = curNode.next;
        preNode.next = nextNode;
        nextNode.prev = preNode;
        curNode.prev = null;
        curNode.next = null;
    }

    public void addLast(DoubleNode newNode) {
        DoubleNode prevNode = tail.prev;
        insertNode(prevNode, newNode);
    }

    public int removeFirst() {//返回key
        int key = head.next.key;
        removeNode(head.next);
        return key;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }
}

class DoubleNode {
    DoubleNode prev;
    DoubleNode next;
    int key;
    int value;
    int cnt;

    public DoubleNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.cnt = 0;
    }
}









/// 2024.03.11

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
