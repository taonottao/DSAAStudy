package my_sort;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/6/5 21:09
 */
class HeapTest{
    int[] elem;
    int usedSize;

    public HeapTest() {
        elem = new int[10];
    }

    public void initHeap(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(isFull()){
                elem = Arrays.copyOf(elem, 2*elem.length);
            }
            elem[i] = arr[i];
            usedSize++;
        }
    }
    public void createHeap(){
        int parent = (usedSize-2)/2;
        for(;parent>=0;parent--) {
            shiftDown(usedSize, parent);
        }
    }

    public boolean isFull(){
        return usedSize == elem.length;
    }

    public void heapSort(){
        int end = usedSize - 1;
        while (end > 0) {
            int tmp = elem[0];
            elem[0] = elem[end];
            elem[end] = tmp;
            shiftDown(end, 0);
            end--;
        }
    }
    private void shiftDown(int usedSized, int parent){
        int child = 2*parent + 1;
        while (child < usedSized){
            if (child + 1 < usedSized) {
                child = elem[child] > elem[child+1] ? child : child+1;
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

public class HeapSort {
    public static void main(String[] args) {
        HeapTest heapTest = new HeapTest();
        int[] arr = {27,15,19,18,28,34,65,49,25,37};
//        heapTest.initHeap(arr);
//        heapTest.createHeap();
//        heapTest.heapSort();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            heap.offer(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.poll();
        }

        System.out.println("***********");
    }
}

