package com.attao.java4;

import org.junit.Test;

import java.util.*;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/8 17:17
 */
public class QueueTest {

    @Test
    public void test2(){
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque2 = new ArrayDeque<>();

        Stack<Integer> stack1 = new Stack<>();

        Deque<Integer> stack2 = new ArrayDeque<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
    }

    @Test
    public void test1(){
        Deque<Integer> deque = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
    }
}
