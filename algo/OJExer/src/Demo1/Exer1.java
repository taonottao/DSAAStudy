package Demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/4 9:14
 */
class Node {
    int val = 0;
    Node left = null;
    Node right = null;

    public Node(int val) {
        this.val = val;
    }
}

public class Exer1 {
    /**
     * 前序遍历
     */
    public int[] preorderTraversal(Node root) {
        // write code here
        // if(root == null){
        //     return null;
        // }
        List<Integer> list = new ArrayList<>();
        preTra(list, root);
        int[] arr = new int[list.size()];
        int i = 0;
        for (int num : list) {
            arr[i] = num;
            i++;
        }

        return arr;
    }
    public void preTra(List<Integer> list, Node root) {
        if (root == null) return;
        list.add(root.val);
        preTra(list, root.left);
        preTra(list, root.right);
    }

    /**
     * 用两个栈来实现一个队列，使用n个元素来完成 n 次在队列尾部插入整数(push)和n次在队列头部删除整数(pop)
     * 的功能。 队列中的元素为int类型。保证操作合法，即保证pop操作时队列内已有元素。
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        // if(stack1.empty() && stack2.empty()){
        stack1.push(node);
        // }
    }
    public int pop() {
        if(stack2.empty() && !stack1.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
