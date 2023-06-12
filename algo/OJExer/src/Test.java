/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/6/12 11:06
 */

class Node {
    public int val;
    public Node left;
    public Node right;
}

public class Test {
    public static Node build() {
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();
        Node f = new Node();
        Node g = new Node();
        a.val = 1;
        b.val = 2;
        c.val = 3;
        d.val = 4;
        e.val = 5;
        f.val = 6;
        g.val = 7;

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        c.right = f;
        return a;
    }

    public static void main(String[] args) {
        Node root = build();
        // 此时这个 root 就相当于树的根节点
        // 当前代码中只有一个引用 root, 但是它管理了 N 个对象
    }
}
