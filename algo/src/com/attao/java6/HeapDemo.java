package com.attao.java6;

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
}
