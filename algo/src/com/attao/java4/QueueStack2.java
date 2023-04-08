package com.attao.java4;

import java.util.Stack;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/8 21:17
 */
public class QueueStack2 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueStack2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x){
        stack1.push(x);
    }

    public int pop(){
        if(empty()){
            return -1;
        }

        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public int peek(){
        if(empty()){
            return -1;
        }

        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }

        }

        return stack2.peek();
    }

    public boolean empty(){
        return stack1.empty() && stack2.empty();
    }

}
