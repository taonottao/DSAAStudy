package Demo1;

import java.util.Arrays;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/9 19:22
 */
public class Exer4 {
    public static void main(String[] args) {
        int[] arr = new int[]{27,15,19,18,28,34,65,49,25,37};
        createHeap(arr, 10);
//        arr = Arrays.copyOf(arr, 2*arr.length);
//        offer(arr, 10, 80);
        pop(arr, 10);
        System.out.println("*********************");
    }
    /**
     * 创建大根堆（向下调整）
     * 时间复杂度 O(n)
     */
    public static void createHeap(int[] arr, int usedSize) {
        int parent = (usedSize - 1) / 2;
        for(;parent >= 0; parent--){
            shiftDown(arr, usedSize, parent);
        }
    }
    private static void shiftDown(int[] arr, int usedSized, int parent){
        int child = 2*parent + 1;
        while (child < usedSized){
            if (child + 1 < usedSized) {
                child = arr[child] > arr[child+1] ? child : child+1;
            }
            if(arr[child] > arr[parent]){
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
                parent = child;
                child = 2*parent + 1;
            }else {
                break;
            }
        }
    }
    /**
     * 插入元素（向上调整）
     *
     */
    public static void offer(int[] arr, int usedSize, int val){
        // 不考虑扩容
        arr[usedSize++] = val;
        shiftUp(arr, usedSize);
    }
    // 时间复杂度：N*log(N)
    private static void shiftUp(int[] arr, int usedSize) {
        int child = usedSize - 1;
        int parent = (child-1)/2;
        while (child > 0) {
            if (arr[parent] < arr[child]) {
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
                child = parent;
                parent = (parent-1)/2;
            }else {
                break;
            }
        }
    }

    /**
     * 删除堆顶元素
     */
    public static void pop(int[] arr, int usedSize){
        //1. 判断是否为空（省略）
        arr[0] = arr[usedSize-1];
        usedSize--;
        // 向下调整
        int parent = (usedSize-1)/2;
        shiftDown(arr, usedSize, 0);

    }
}
