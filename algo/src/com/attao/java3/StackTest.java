package com.attao.java3;

import java.util.Stack;

/**
 * 栈
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/6 21:59
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Integer a = stack.pop();
        System.out.println(a);
        Integer b1 = stack.peek();
        System.out.println(b1);
        Integer b2 = stack.peek();
        System.out.println(b2);
        System.out.println(stack.size());

    }
}
