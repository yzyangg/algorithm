package leetcode.offer;

import java.util.HashMap;
import java.util.Map;

public class p031 {
}

class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {
        }

        ;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int cap;
    private Node head, tail;
    private Map<Integer, Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.size = 0;
        this.cap = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        //刚使用过，移动到链表头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            addToHead(newNode);
            cache.put(key, newNode);
            size++;
            if (size > cap) {
                cache.remove(removeTail());
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    public int removeTail() {
        Node prev = tail.prev;
        removeNode(prev);
        return prev.key;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}