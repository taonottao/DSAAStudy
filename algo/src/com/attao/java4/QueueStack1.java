package com.attao.java4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/8 18:00
 */
public class QueueStack1 {

    private Queue<Integer> qu1;
    private Queue<Integer> qu2;

    public QueueStack1() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    public void push(int x){
        if(!qu1.isEmpty()){
            qu1.offer(x);
        } else if (!qu2.isEmpty()) {
            qu2.offer(x);
        }else{
            qu1.offer(x);
        }
    }

    public int pop(){

        if(empty()){
            return -1;
        }
        if(!qu1.isEmpty()){
            while (qu1.size() > 0){
                qu2.offer(qu1.poll());
            }
            return qu1.poll();
        } else {
            while (qu2.size() > 0){
                qu1.offer(qu2.poll());
            }
            return qu2.poll();
        }

    }

    //peek
    public int top(){
        if(empty()){
            return -1;
        }
        int val = -1;
        if(!qu1.isEmpty()){
            while (qu1.size() >= 0){
                val = qu1.poll();
                qu2.offer(val);
            }
        } else {
            while (qu2.size() > 0){
                val = qu2.poll();
                qu1.offer(val);
            }
        }
        return val;

    }

    public boolean empty(){
        return qu1.isEmpty() && qu2.isEmpty();
    }

}
