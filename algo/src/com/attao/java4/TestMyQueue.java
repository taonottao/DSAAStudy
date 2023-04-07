package com.attao.java4;

import org.junit.Test;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/7 23:41
 */
public class TestMyQueue {

    @Test
    public void test1(){
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
    }
}
