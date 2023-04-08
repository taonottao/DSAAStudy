package com.attao.java4;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/8 16:50
 */
public class MyCircularQueue {

    private int[] elem;
    private int front;//表示队列的头
    private int rear;//表示队列的尾

    public MyCircularQueue(int k) {
        this.elem =new int[k];
    }

    /**
     * 入队列
     * @param value
     * @return
     */
    public boolean enQueue(int value){
        //1.检查队列是不是满的
        if(isFull()){
            return false;
        }
        //2.
        elem[rear] = value;
        rear = (rear + 1) % elem.length;
        return true;
    }

    /**
     * 出队列
     * @return
     */
    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        front = (front + 1) % elem.length;
        return true;
    }

    /**
     * 队头元素
     * @return
     */
    public int Front(){
        if(isEmpty()){
            return -1;
        }
        return elem[front];
    }

    /**
     * 队尾元素
     * @return
     */
    public int Rear(){
        if(isEmpty()){
            return -1;
        }
        int index = (rear == 0)? elem.length - 1 : rear - 1;
        return elem[index];
    }

    public boolean isEmpty(){
        return front == rear;
    }

    /**
     * 队列是否为满
     * @return
     */
    public boolean isFull(){
//        if((rear + 1)%elem.length == front){
//            return true;
//        }
//        return false;

        return (rear + 1)%elem.length == front;
    }
}
