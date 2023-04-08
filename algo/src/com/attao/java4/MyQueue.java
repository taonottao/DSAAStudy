package com.attao.java4;

import com.attao.java3.EmptyException;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/7 23:31
 */
public class MyQueue {

    static class Node{
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node head;
    public Node last;
    public int usedSize;

    //入队
    public void offer(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            last = node;
        }else {
            last.next = node;
            last = node;
        }

        usedSize++;

    }

    //出队
    public int poll(){
        if(empty()){
            throw new EmptyException("队列为空！！！");
        }

        int ret = head.val;
        head = head.next;
        if(head == null){
            last = null;
        }
        usedSize--;
        return ret;
    }

    public boolean empty(){
        return usedSize == 0;
    }

    public int peek(){
        if(empty()){
            throw new EmptyException("队列为空！！！");
        }

        return head.val;
    }

    public int getUsedSize(){
        return usedSize;
    }

}
