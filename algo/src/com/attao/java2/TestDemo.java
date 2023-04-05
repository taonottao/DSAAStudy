package com.attao.java2;

import org.junit.Test;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/5 21:19
 */
public class TestDemo {

    @Test
    public void test(){
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(3);
        myLinkedList.display();
        System.out.println("*****************************");
//        myLinkedList.addIndex(3,99);
//        myLinkedList.display();
//        myLinkedList.remove(1);
        myLinkedList.removeAllKey(3);
        myLinkedList.display();
    }

}
