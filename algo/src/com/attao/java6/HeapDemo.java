package com.attao.java6;

import java.util.Arrays;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/4/13 17:20
 */
public class HeapDemo {

    public int[] elem;
    public int usedSize;

    public HeapDemo() {
        this.elem = new int[10];
    }

    public void initElem(int[] array){
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }
    }

    /**
     * 时间复杂度：O(N)
     */
    public void createHeap(){
        for (int parent = (usedSize-1-1)/2; parent >= 0; parent--) {
            shiftDown(parent, usedSize);
        }
    }

    /**
     * 父亲下标
     * 每棵树的结束下标
     * @param parent
     * @param len
     */
    private void shiftDown(int parent, int len){
        int child = 2*parent + 1;
        //最起码有左孩子
        while (child < len){
            //有右孩子的情况下
            //child 一定是左右孩子最大值的下标
            if(child + 1 < len && elem[child] < elem[child+1]){
                child++;
            }
            if(elem[child] > elem[parent]){
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = 2*parent + 1;
            }else {
                break;
            }
        }
    }


    private void shiftUp(int child){
        int parent = (child - 1) / 2;
        while(child > 0){
            if(elem[child] > elem[parent]){
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent = (child - 1) / 2;
            }else {
                break;
            }
        }
    }
    //向上调整建堆的时间复杂度：O(n*logn)
    public void offer(int val){
        if(isFull()){
            elem = Arrays.copyOf(elem, 2 * elem.length);
        }
        elem[usedSize++] = val;
        //向上调整
        shiftUp(usedSize  - 1);
    }
    public boolean isFull(){
        return usedSize == elem.length;
    }


    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("堆为空！！！");
        }
        int tmp = elem[0];
        elem[0] = elem[usedSize - 1];
        elem[usedSize - 1] = tmp;
        usedSize--;
        shiftDown(0, usedSize);
        return tmp;
    }

    public boolean  isEmpty(){
        return usedSize == 0;
    }

    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("堆为空！！！");
        }
        return elem[0];
    }

    /**
     * 堆的排序:降序
     * 时间复杂度：O(n*logn)
     * 空间复杂度：O(1)
     */
    public void heapSort(){
        int end  = usedSize - 1;
        while (end > 0){
            int tmp = elem[0];
            elem[0] = elem[end];
            elem[end] = tmp;
            shiftDown(0, end);
            end--;
        }

    }
}
