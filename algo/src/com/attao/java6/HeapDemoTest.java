package com.attao.java6;

import org.junit.Test;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/13 17:58
 */
public class HeapDemoTest {
    public static void main(String[] args) {
        HeapDemo heapDemo = new HeapDemo();
        int[] array = new int[]{27,15,19,18,28,34,65,49,25,37};
        heapDemo.initElem(array);
        heapDemo.createHeap();
//        heapDemo.offer(80);
        heapDemo.pop();
        System.out.println();
    }

    @Test
    public void test1(){
        HeapDemo heapDemo = new HeapDemo();
        int[] array = new int[]{27,15,19,18,28,34,65,49,25,37};
        heapDemo.initElem(array);
        heapDemo.createHeap();
        heapDemo.heapSort();
        System.out.println();
    }
}
