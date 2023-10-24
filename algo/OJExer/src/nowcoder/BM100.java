package nowcoder;

import java.util.HashMap;

/**
 * 设计LRU缓存结构
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/24 14:57
 */
public class BM100 {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(){}

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    HashMap<Integer, Node> cache = new HashMap<>();
    public int capacity;
    public int size;
    Node head;
    Node tail;

    public BM100(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node tmp = cache.get(key);
        if (tmp == null) {
            return -1;
        }
        moveToHead(tmp);
        return tmp.val;
    }

    public void set(int key, int val) {
        Node tmp = cache.get(key);
        if (tmp == null) {
            Node node = new Node(key, val);
            cache.put(key, node);
            addToHead(node);
            size++;
            if (size > capacity) {
                Node ret = removeTail();
                size--;
                cache.remove(ret.key);
            }
        } else {
            tmp.val = val;
            moveToHead(tmp);
        }
    }

    private Node removeTail() {

        Node ret = tail.prev;
        removeNode(ret);
        return ret;
    }

    private void removeNode(Node ret) {
        ret.prev.next = ret.next;
        ret.next.prev = ret.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }

    private void moveToHead(Node tmp) {
        removeNode(tmp);
        addToHead(tmp);
    }
}
