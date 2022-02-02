package misc;

import java.util.HashMap;
import java.util.Map;

/**
 * LRUCache : LRUCache
 *
 */
public class LRUCache {

    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(0,0);
    private Node tail = new Node(0,0);
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int val) {
        Node n = map.get(key);
        if (n == null) {
            n = new Node(key, val);
            if (map.size() == capacity) {
                map.remove(head.next.key);
                deleteNode(head.next);
            }
        } else {
            n.val = val;
            deleteNode(n);
        }

        map.put(key, n);
        addToTail(n);
    }

    public int get(int key) {
        int result = -1;
        if(map.containsKey(key)) {
            Node n = map.get(key);
            result = n.val;
            deleteNode(n);
            addToTail(n);
        }

        return result;
    }

    void deleteNode(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    void addToTail(Node n) {
        n.prev = tail.prev;
        n.next = tail;
        tail.prev.next = n;
        tail.prev = n;
    }

    private class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main (String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
