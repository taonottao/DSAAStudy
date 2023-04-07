package com.attao.java3;

import java.util.Stack;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/7 22:33
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val){
        stack.push(val);
        if(minStack.empty()){
            minStack.push(val);
        }else {
            if(val <= minStack.peek()){
                minStack.push(val);
            }
        }

    }

    public void pop(){
        if(!stack.empty()){
            Integer val = stack.pop();
            if(val.equals(minStack.peek())){
                minStack.pop();
            }
        }

    }

    public int top(){
        if(!stack.empty()){
            return stack.peek();
        }

        return -1;

    }

    public int getMin(){
        return minStack.peek();
    }
}
