package leetcode.day6;

import java.util.HashMap;
import java.util.Map;

public class p146 {
    public static void main(String[] args) {

    }
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

    private Map<Integer, Node> cache = new HashMap<>();
    private int size;
    private int cap;
    private Node head, tail;

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
                Node tail = removeTail();
                cache.remove(tail.key);
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

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    public Node removeTail() {
        Node prev = tail.prev;
        removeNode(prev);
        return prev;
    }
}

