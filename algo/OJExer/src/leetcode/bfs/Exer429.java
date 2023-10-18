package leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N 叉树的层序遍历
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/10/16 20:54
 */

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class Exer429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> tmp = new ArrayList<>();
            while(sz > 0){
                Node t = q.poll();
                sz--;
                tmp.add(t.val);
                for(Node child : t.children){
                    if(child != null){
                        q.offer(child);
                    }
                }
            }
            ret.add(tmp);
        }
        return ret;
    }
}
