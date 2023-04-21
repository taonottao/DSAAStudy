/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/21 18:16
 */
public class HashBuck {
    static class Node{
        public int key;
        public int val;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

    }

    public Node[] arr;

    public int usedSize;

    public static final double LOAD_FACTOR = 0.75;

    public HashBuck(){
        arr = new Node[10];
    }

    public void put(int key, int val){
        int index = key % arr.length;
        Node cur =  arr[index];
        while (cur != null){
            if(cur.key == key){
                cur.val = val;
                return;
            }
            cur = cur.next;
        }

        //头插法进行插入
        Node node = new Node(key, val);
        node.next = arr[index];
        arr[index] = node;
        usedSize++;
        if(calculateLoadFactor() > LOAD_FACTOR){
            //扩容
            resize();
        }

    }

    private void resize() {
        Node[] newArr = new Node[2*arr.length];

        for (int i = 0; i < arr.length; i++) {
            Node cur = arr[i];
            while (cur != null){
                int index = cur.key % newArr.length;
                Node curNext = cur.next;
                cur.next = newArr[index];
                newArr[index] = cur;
                cur = curNext;
            }
        }

        arr = newArr;
    }

    //计算负载因子
    private double calculateLoadFactor(){
        return usedSize*1.0 / arr.length;
    }

    public int get(int key){
        int index = key % arr.length;
        Node cur = arr[index];
        while (cur != null){
            if(cur.key == key){
                return cur.val;
            }
            cur = cur.next;
        }

        return  -1;
    }


}
