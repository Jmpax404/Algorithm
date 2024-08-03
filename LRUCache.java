import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

}

class LRUCache {
    int capacity;
    MyHashMap map;
    DoubleLinkedList list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new MyHashMap();
        this.list = new DoubleLinkedList();
    }

    public int get(int key) {
        DoubleNode node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            list.changeToLast(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        DoubleNode node = map.get(key);
        if (node == null) {
            if (list.size >= capacity) {
                int firstKey = list.removeFirst();
                if (firstKey != -1) {
                    map.remove(firstKey);
                }
            }
            node = list.addLast(key, value);
            map.put(key, node);
        } else {
            node.value = value;
            list.changeToLast(node);
        }
    }
}

class MyHashMap {
    DoubleNode[] map = new DoubleNode[10001];//空间换时间

    public void put(int key, DoubleNode node) {
        map[key] = node;
    }

    public DoubleNode get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = null;
    }
}

class DoubleLinkedList {
    DoubleNode head;
    DoubleNode tail;
    int size;

    public DoubleLinkedList() {
        head = new DoubleNode(0, 0);
        tail = new DoubleNode(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public DoubleNode addLast(int key, int value) {
        DoubleNode node = new DoubleNode(key, value);
        addLast(node);
        size++;
        return node;
    }

    private void addLast(DoubleNode node) {
        DoubleNode prevNode = tail.prev;
        DoubleNode nextNode = tail;
        prevNode.next = node;
        node.prev = prevNode;
        node.next = nextNode;
        nextNode.prev = node;
    }

    public int removeFirst() {//return key
        if (head.next != tail) {
            DoubleNode node = head.next;
            head.next = node.next;
            node.next.prev = head;
            int key = node.key;
            node.next = null;
            node.prev = null;
            node = null;
            size--;
            return key;
        } else {
            return -1;
        }
    }

    public void changeToLast(DoubleNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addLast(node);
    }

}

class DoubleNode {
    DoubleNode prev;
    DoubleNode next;
    int key;
    int value;

    public DoubleNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

}


class LRUCache00 extends LinkedHashMap<Integer, Integer> {
    private int maxSize;

    public LRUCache00(int capacity) {
        super(capacity, 0.75f, true);
        maxSize = capacity;
    }

    public int get(int key) {
        return getOrDefault(key, -1);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > maxSize;
    }
}
