package com.attao.java3;

import java.util.Stack;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/6 22:22
 */
public class MyStackTest {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        Integer a = myStack.pop();
        System.out.println(a);
        Integer b1 = myStack.peek();
        System.out.println(b1);
        Integer b2 = myStack.peek();
        System.out.println(b2);
        System.out.println(myStack.isEmpty());
    }
}
