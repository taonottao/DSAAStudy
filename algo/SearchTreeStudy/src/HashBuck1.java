/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/21 19:36
 */
public class HashBuck1<K, V> {

    static class Node<K, V> {
        public K key;
        public V val;
        public Node<K, V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node<K, V>[] arr = (Node<K, V>[])new Node[10];
    public int usedSize;

    public void put(K key, V val){
        int hash = key.hashCode();
        int index = hash % arr.length;
        Node<K, V> cur = arr[index];
        while (cur != null){
            if(cur.key.equals(key)){
                cur.val = val;
                return;
            }
            cur = cur.next;
        }

        Node<K, V> node = new Node<>(key, val);
        node.next = arr[index];
        arr[index] = node;
        usedSize++;

    }

    public V get(K key){
        int hash = key.hashCode();
        int index = hash % arr.length;
        Node<K, V> cur = arr[index];
        while (cur != null){
            if(cur.key.equals(key)){
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }

}
