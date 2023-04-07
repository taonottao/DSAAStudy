package com.attao.java3;

import java.util.Arrays;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/6 22:08
 */
public class MyStack {

    public int[] elem;
    public int usedSize;

    public MyStack() {
        this.elem = new int[10];
    }

    //压栈
    public void push(int val){
        if(isFull()){
            //扩容
            elem = Arrays.copyOf(elem, 2*elem.length);
        }
        elem[usedSize++] = val;
    }

    public boolean isFull(){
        return usedSize == elem.length;
    }

    //出栈
    public int pop(){
        if(isEmpty() ){
            throw new EmptyException("栈是空的!!!!");
        }
        return elem[--usedSize];
    }
    public boolean isEmpty(){

        return usedSize == 0;
    }

    public int peek(){
        if(isEmpty() ){
            throw new EmptyException("栈是空的!!!!");
        }
        return elem[usedSize - 1];
    }

}
